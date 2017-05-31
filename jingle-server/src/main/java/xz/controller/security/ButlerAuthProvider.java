package xz.controller.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import xz.dao.UserMapper;
import xz.model.TUser;

import java.util.Collection;

/**
 * Created by Jinhua on 2017/2/17.
 */
@Component
public class ButlerAuthProvider implements AuthenticationProvider {
	
	@Autowired
	UserMapper userDao;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String)authentication.getCredentials();
		
		TUser user = userDao.selectByAccount(username);
//		if(users.size()==0) {
//			users = userDao.fetchByStr(username);
//		}
		if(user==null){
			throw new BadCredentialsException("Account  not found.");
		}
		ButlerUserDetail dbUser = new ButlerUserDetail(user);
		
		
		//加密过程在这里体现
		if (!password.equals(dbUser.getPassword())) {
			throw new BadCredentialsException("Wrong password.");
		}
		
		Collection<? extends GrantedAuthority> authorities = dbUser.getAuthorities();
		return new UsernamePasswordAuthenticationToken(dbUser, password, authorities);
	}
	
	@Override
	public boolean supports(Class<?> aClass) {
		return true;
	}
}
