package com.tuana9a.learnjavaspringweb.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.tuana9a.learnjavaspringweb.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    @Autowired
    private AppConfig config;

    public String generateToken(String username) {
        return config.JWT_PREFIX + JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + config.JWT_EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(config.JWT_SECRET));
    }

    public String decodeToken(String token) {
        try {
            return JWT.require(Algorithm.HMAC512(config.JWT_SECRET))
                    .build().verify(token.replace(config.JWT_PREFIX, ""))
                    .getSubject();
        } catch (Exception ignored) {
        }
        return null;
    }
}
