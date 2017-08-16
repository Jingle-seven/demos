package xz.controller.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import xz.model.AssetUser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Jinhua on 2017/2/22.
 */
public class ButlerUserDetail extends AssetUser implements UserDetails {
    
    ButlerUserDetail() {
    }
    
    public ButlerUserDetail(AssetUser user) {
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
    
    public AssetUser castToUser() {
        AssetUser user = new AssetUser();
        user.setAccount(this.getAccount());
        user.setAuthority(this.getAuthority());
        user.setName(this.getName());
        user.setPassword(this.getPassword());
        user.setId(this.getId());
        user.setCreateTime(this.getCreateTime());
        user.setUpdateTime(this.getUpdateTime());
        return user;
    }
}
