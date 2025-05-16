package com.movieFlix.moviefliex.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.movieFlix.moviefliex.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Component
public class TokenService {

    @Value("${movieflix.security.secret}")
    private String secret;

    public String generateToken(User user) {
        Algorithm algorithm = Algorithm.HMAC256(secret); //token gerado

        return JWT.create()
                .withSubject(user.getEmail()) //info do token
                .withClaim("userId", user.getId()) // mostrar id
                .withClaim("name", user.getName()) // mostrar name
                .withExpiresAt(Instant.now().plusSeconds(86400)) //expira em 24hrs
                .withIssuedAt(Instant.now()) // quando foi gerado
                .withIssuer("API MovieFlix") // por quem foi gerado
                .sign(algorithm);
    }

    public Optional<JWTUserData> verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            DecodedJWT jwt = JWT.require(algorithm)
                    .build()
                    .verify(token);

            return Optional.of( JWTUserData
                    .builder()
                    .id(jwt.getClaim("userId").asLong())
                    .name(jwt.getClaim("name").asString())
                    .email(jwt.getSubject())
                    .build());
        } catch (JWTVerificationException ex) {
            return Optional.empty();
        }



    }
}
