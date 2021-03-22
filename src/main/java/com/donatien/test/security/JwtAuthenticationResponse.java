package com.donatien.test.security;

import io.swagger.v3.oas.annotations.Parameters;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @author donatien
 * @created 22/03/2021 - 3:49 AM
 * @project test
 */

public class JwtAuthenticationResponse {

    private String accessToken;

    private String refreshToken;

    private String phoneToken;


    private String tokenType;

    private Long expiryDuration;

    private String username; // Informations supplémentaires lors de la connexion de l'utilisateur

    private Collection<? extends GrantedAuthority> authorities;

    private String refreshTokenOpt;


    private Long expiryDurations;

    private String phoneNumber;

    private ResponseEntity <?> verificationcode;

    private List<Parameters> basicParameters;

    public JwtAuthenticationResponse ( String accessToken, String refreshToken, Collection <? extends GrantedAuthority> authorities ) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expiryDuration = expiryDuration;
        this.tokenType = "Bearer ";

        // informations supplémentaires lors de la connexion d'un utilisateur
        this.username = username;
        this.authorities = authorities;
        this.basicParameters=basicParameters;
    }
}
