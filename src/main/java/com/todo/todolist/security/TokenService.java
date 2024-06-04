package com.todo.todolist.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.todo.todolist.entity.User;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            String token = JWT.create()
                .withIssuer("todolist")
                .withSubject(user.getEmail())
                .withExpiresAt(this.generationExpirationDate())
                .sign(algorithm);
            
            return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error while authentication");
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.require(algorithm).withIssuer("todolist")
                .build()
                .verify(token)
                .getSubject();

        } catch (JWTVerificationException exception) {
            return null;
        }

    }

    public Instant generationExpirationDate() {
        return LocalDateTime
            .now()
            .plusHours(2)
            .toInstant(ZoneOffset.of("-03:00"));
    }
}
