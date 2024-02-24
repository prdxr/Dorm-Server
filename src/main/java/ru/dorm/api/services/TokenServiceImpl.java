package ru.dorm.api.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import ru.dorm.api.properties.TokenProperties;

import java.security.Key;
import java.util.Date;
@Service
@AllArgsConstructor
public class TokenServiceImpl implements TokenService {
    private final TokenProperties tokenProperties;
    public String generateToken(String login){
        return Jwts.builder()
                .setSubject(login)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() * tokenProperties.getTtl()))
                .signWith(SignatureAlgorithm.HS384, generateKey())
                .compact();
    }

    @Override
    public String parseToken(String token) {
        return null;
    }
    @SneakyThrows
    private Key generateKey(){
        byte[] keyBytes = tokenProperties.getKey().getBytes();
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
