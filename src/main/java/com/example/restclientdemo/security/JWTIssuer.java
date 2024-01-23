package com.example.restclientdemo.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class JWTIssuer {
    @Autowired
    private final JWTProperties jwtProperties;
    public String issue(long userid, String username, List<String> roles){
        return JWT.create()
                .withSubject(String.valueOf(userid))
                .withExpiresAt(Instant.now().plus(Duration.ofMinutes(1)))
                .withClaim("email",username)
                .withClaim("roles",roles)
                .sign(Algorithm.HMAC256(jwtProperties.getSecret_key()));
    }
}
