##  Spring Security获取已登录的用户信息的两种方法  
第一种是直接从session中手动拿:
```
@RequestMapping(value = "/user", method = RequestMethod.GET)
public ResponseEntity<Map<String, Object>> getUser(HttpSession httpSession){
   Authentication au;
   CloudinsUser user = null;
   CloudinsUserDetail userDetail;
   String[] meta = new String[1];
   SecurityContext ctx =
         (SecurityContext) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
   if(ctx!=null) {
      au = ctx.getAuthentication();
      userDetail = (CloudinsUserDetail) au.getPrincipal();
      if (userDetail != null){
         userDetail.setPassword("");
	//userDetail直接转成json会报错,需要从中构造一个简单对象
         user = userDetail.castToCloudinsUser();
         meta[0] = "UserId:" +user.getId();
      }
   }
   return SeverUtil.cacheResp(makeResMap(user,meta));
}
```
第二种是Spring Security提供的方法:
```
@RequestMapping(value = "/user", method = RequestMethod.GET)
public ResponseEntity<Map<String, Object>> getUser(){
   Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   System.out.println(principal);
   return null;
}
```
其中principal 也不能直接转化为json
   
