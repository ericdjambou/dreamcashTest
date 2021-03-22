package com.donatien.test.common;

import com.donatien.test.entities.Utilisateur;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author donatien
 * @created 22/03/2021 - 3:19 AM
 * @project test
 */

public class CustomUserDetails extends Utilisateur implements  UserDetails {
    @Override
    public Collection <? extends GrantedAuthority> getAuthorities ( ) {
        return null;
    }

    @Override
    public String getPassword ( ) {
        return getPassword ();
    }

    @Override
    public boolean isAccountNonExpired ( ) {
        return true;
    }

    @Override
    public boolean isAccountNonLocked ( ) {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired ( ) {
        return true;
    }

    @Override
    public boolean isEnabled ( ) {
        return true;
    }


}
