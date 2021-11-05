package com.scaffolding.learn.config.security;

import com.scaffolding.learn.dto.LoginUserDto;
import com.scaffolding.learn.entity.Role;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2020/11/23 22:20
 */
public class SecurityUser extends LoginUserDto implements UserDetails, Serializable {

    @Setter
    private Boolean accountNonExpired=true;
    @Setter
    private Boolean accountNonLocked=true;
    @Setter
    private Boolean credentialsNonExpired=true;
    @Setter
    private Boolean enabled=true;
    public SecurityUser (LoginUserDto user) {
        if(user != null) {
            BeanUtils.copyProperties(user, this);
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        List<Role> userRoles = this.getRoles();
        if(userRoles != null){
            for (Role role : userRoles) {
                // Security 内部 需要使用ROLE_前缀来校验
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role.getName());
                authorities.add(authority);
            }
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }


    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
