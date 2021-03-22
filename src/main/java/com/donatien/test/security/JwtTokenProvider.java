package com.donatien.test.security;

import com.donatien.test.common.CustomUserDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;
import java.util.stream.DoubleStream;


@Component
public class JwtTokenProvider {

    @Value ("${app.jwt.expiration}")
    private Long jwtExpirationInMs;

    /**
     * Génère un jeton à partir d'un objet principal. Incorporer le jeton d'actualisation dans le jwt
     * afin qu'un nouveau JWT puisse être créé
     */
    public String generateToken( CustomUserDetails customUserDetails) {
        Instant expiryDate = Instant.now().plusMillis(jwtExpirationInMs);
        return generateToken ( customUserDetails );

    }


}
