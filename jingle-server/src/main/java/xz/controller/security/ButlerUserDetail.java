package xz.controller.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import xz.model.TUser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Jinhua on 2017/2/22.
 */
public class ButlerUserDetail extends TUser implements UserDetails {
	
	ButlerUserDetail(){}
	
	public ButlerUserDetail(TUser user) {
		super.setAccount(user.getAccount());
		super.setAuthority(user.getAuthority());
		super.setId(user.getId());
		super.setName(user.getName());
		super.setPassword(user.getPassword());
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auth = new ArrayList<>();
		auth.add(new SimpleGrantedAuthority(super.getAuthority().toString()));
		System.out.println(auth);
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
	
	public TUser castToUser() {
		return new TUser()
			.setAccount(this.getAccount())
			.setAuthority(this.getAuthority())
			.setId(this.getId())
			.setName(this.getName())
			.setPassword(this.getPassword());
	}
}
