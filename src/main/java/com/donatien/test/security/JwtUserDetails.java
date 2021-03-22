package com.donatien.test.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * @author donatien
 * @created 20/03/2021 - 1:30 PM
 * @project test
 */
@Component
public class JwtUserDetails implements UserDetails {

    private String userName;
    private String token;
    private Long id;
    private Collection <? extends GrantedAuthority> authorities;

    public JwtUserDetails ( String userName, long id, String token, List<GrantedAuthority> grantedAuthorities ) {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return userName;
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


    public String getUserName() {
        return userName;
    }

    public String getToken() {
        return token;
    }


    public Long getId() {
        return id;
    }
}
