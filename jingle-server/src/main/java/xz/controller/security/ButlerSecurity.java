package xz.controller.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * @EnableWebSecurity: 禁用Boot的默认Security配置，配合@Configuration启用自定义配置
 * 需要扩展WebSecurityConfigurerAdapter
 * @EnableGlobalMethodSecurity(prePostEnabled = true): 启用Security注解，如最常用的@PreAuthorize
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ButlerSecurity extends WebSecurityConfigurerAdapter {
	static final String ADMIN_AUTH = "1";
	static final String USER_AUTH = "0";
	
	@Autowired
	private ButlerAuthProvider provider;
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(provider);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/js/*", "/img/*").permitAll()
				.antMatchers("/admin/*").hasAnyAuthority(ADMIN_AUTH)
				.anyRequest().authenticated()
				.and().formLogin().permitAll()
				.and().logout().permitAll();
		
		http.csrf().disable();
	}
	
	
}
