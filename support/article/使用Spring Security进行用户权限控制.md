##  使用Spring Security进行用户权限控制  
系统比较简单,所以只有用户表, 角色表和域表, 没有权限表. 各个域的用户是隔离的, 因为前后端分离, 控制起来格外不方便, 不过好歹是用filter实现了,bug还很多改天再说.
	现在的问题就是登录 ,前端获取登录用户以及权限拦截 .其中比较花时间的是用户登录.
登录可以使用AuthenticationProvider 或者UserDetailsService实现,我倾向于使用前者,看起来DIY程度比较高,下面是代码:
```
@Component
public class CloudinsAuthProvider implements AuthenticationProvider {
   
   @Autowired
   CloudinsUserDao userDao;
   @Autowired
   CloudinsRoleDao roleDao;
   
   @Override
   public Authentication authenticate(Authentication authentication) throws AuthenticationException {
      String username = authentication.getName();
      String password = (String) authentication.getCredentials();
      
      List<CloudinsUser> users = userDao.fetchByAccount(username);
      if(users.size()==0) {
         users = userDao.fetchByName(username);
      }
      if(users.size()==0){
         throw new BadCredentialsException("Account and username not found.");
      }
      CloudinsUserDetail dbUser = new CloudinsUserDetail(users.get(0));
      
      
      //加密过程在这里体现
      if (!password.equals(dbUser.getPassword())) {
         throw new BadCredentialsException("Wrong password.");
      }
      
      Collection<? extends GrantedAuthority> authorities = dbUser.getAuthorities(roleDao);
      return new UsernamePasswordAuthenticationToken(dbUser, password, authorities);
   }
   
   @Override
   public boolean supports(Class<?> aClass) {
      return true;
   }
}
```

其中用到的user需要实现UserDetails接口,其中的属性信息我写在父类中:
```
public class CloudinsUserDetail extends CloudinsUser implements UserDetails {
   
   CloudinsUserDetail(){}
   public CloudinsUserDetail(CloudinsUser user){
      super(user);
   }
   
   @Deprecated
   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      return new ArrayList<>();
   }
   public Collection<? extends GrantedAuthority> getAuthorities(YarnJooqDao<CloudinsRole,Long> roleDao) {
      List<GrantedAuthority> auth = new ArrayList<>();
      CloudinsRole role = roleDao.fetchOneById(super.getRoleId());
      auth.add(new SimpleGrantedAuthority(role.getName()));
      return auth;
   }
   
   @Override
   public String getPassword() {
      return super.getPassword();
   }
   
   @Override
   public String getUsername() {
      return super.getAccount();
   }
   
   @Override
   public boolean isAccountNonExpired() {
      return true;
   }
   
   @Override
   public boolean isAccountNonLocked() {
      return true;
   }
   
   @Override
   public boolean isCredentialsNonExpired() {
      return true;
   }
   
   @Override
   public boolean isEnabled() {
      return true;
   }
}
```

之后就是核心的WebSecurityConfigurerAdapter ,在这里选择用户登录时的验证方式,以及拦截配置:
```
@Configuration
//@EnableWebSecurity: 禁用Boot的默认Security配置，配合@Configuration启用自定义配置
// （需要扩展WebSecurityConfigurerAdapter）
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true): 启用Security注解，
// 例如最常用的@PreAuthorize
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CloudinsSecurity extends WebSecurityConfigurerAdapter {
   @Autowired
   private CloudinsAuthProvider provider;
   @Autowired
   private CloudinsUserDetailsService userService;
   
   //两种验证用户方式选一种
// @Override
// protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    auth.userDetailsService(this.userService);
// }
   @Autowired
   public void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.authenticationProvider(provider);
   }
   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests()
            
            .antMatchers("/help","/api/v1/manage/user_register","/api/v1/manage/user","/**/*.js","/**/*.json","/**/*.html","/**/*.css","/**/*.png",
                  "/**/*.jpg", "/**/*.gif","/**/*.woff2","/**/*.svg","/**/*.ttf","/**/*.eot","/**/*.map")
            .permitAll()
            .anyRequest().authenticated()
            .antMatchers("/warn","/sysetting","/setting","/api/v1/manage/roles","/api/v1/receive/*")
            .hasAnyRole(Const.ROLE_SUPER_ADMIN)
            .and().formLogin().loginPage("/user_login").loginProcessingUrl("/login_process")
                .successForwardUrl("/api/v1/manage/user").permitAll()
            .and().logout().permitAll();
//    关闭csrf 防止循环定向
      http.csrf().disable();
   }
}
```

以上定义了使用AuthenticationProvider 进行用户验证,对很多静态资源不做拦截,其他url需要登录,某些url需要特定角色才能打开,登录页面是/user_login,登录表单提交url是/login_process. 于是我们就完成了简单的用户分级权限控制,关于具体的mvc方法,还能用注解单独控制:
```
@PreAuthorize("hasAnyRole('ROLE_FIELD_ADMIN','ROLE_SUPER_ADMIN')")
@RequestMapping(value = "/users", method = RequestMethod.DELETE)
public ResponseEntity<Map<String, Object>> removeUser(@RequestParam Long id) {...}
```



获取登录用户[前一篇日志](https://github.com/Jingle-seven/demos/blob/master/support/article/Spring%20Security%E8%8E%B7%E5%8F%96%E5%B7%B2%E7%99%BB%E5%BD%95%E7%9A%84%E7%94%A8%E6%88%B7%E4%BF%A1%E6%81%AF%E7%9A%84%E4%B8%A4%E7%A7%8D%E6%96%B9%E6%B3%95.md)有说, 就是这么煎蛋, 就是这么帅气!!!
   
