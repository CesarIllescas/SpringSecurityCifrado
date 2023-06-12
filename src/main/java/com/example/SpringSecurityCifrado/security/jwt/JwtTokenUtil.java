package com.example.SpringSecurityCifrado.security.jwt;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

/**
 * Métodos para generar y validar los token JWT
 */
@Component
public class JwtTokenUtil {

    private static final Duration JWT_TOKEN_VALIDITY = Duration.ofMinutes(20);
    private static final Logger log = LoggerFactory.getLogger(JwtTokenUtil.class);

    private final Algorithm hmac512;
    private final JWTVerifier verifier;

    public JwtTokenUtil(@Value("${jwt.secret}") final String secret) {
        this.hmac512 = Algorithm.HMAC512(secret);
        this.verifier = JWT.require(this.hmac512).build();
    }

    public String generateJwtToken(final Authentication authentication) {

        final Instant now = Instant.now();
        UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
        return JWT.create()
                .withSubject(userPrincipal.getUsername())
                .withIssuer("app")
                .withIssuedAt(now)
                .withExpiresAt(now.plusMillis(JWT_TOKEN_VALIDITY.toMillis()))
                .sign(this.hmac512);
    }
    public String validateTokenAndGetUsername(final String token) {
        try {
            return verifier.verify(token).getSubject();
        } catch (final JWTVerificationException verificationEx) {
            log.warn("token invalid: {}", verificationEx.getMessage());
            return null;
        }
    }

}