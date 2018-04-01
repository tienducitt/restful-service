package com.eventgate.backend.service.service;

import com.eventgate.backend.service.dto.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class JwtService {

    @Value("${jwt.expire.hours}")
    private Long expireHours;

    @Value("${jwt.token.secret}")
    private String plainSecret;
    private String encodedSecret;

    @PostConstruct
    protected void init() {
        this.encodedSecret = generateEncodedSecret(this.plainSecret);
    }

    public JwtUser getUser(String token) {
        return getUser(this.encodedSecret, token);
    }

    public String getToken(JwtUser jwtUser) {
        return getToken(this.encodedSecret, jwtUser);
    }

    private String generateEncodedSecret(String plainSecret) {
        if (StringUtils.isEmpty(plainSecret)) {
            throw new IllegalArgumentException("JWT secret cannot be null or empty.");
        }
        return Base64
                .getEncoder()
                .encodeToString(this.plainSecret.getBytes());
    }

    private Date getExpirationTime() {
        Date now = new Date();
        Long expireInMs = TimeUnit.HOURS.toMillis(expireHours);
        return new Date(expireInMs + now.getTime());
    }

    private JwtUser getUser(String encodedSecret, String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(encodedSecret)
                .parseClaimsJws(token)
                .getBody();
        String email = claims.getSubject();
        String role = (String) claims.get("role");
        JwtUser securityUser = new JwtUser();
        securityUser.setEmail(email);
        securityUser.setRole(role);
        return securityUser;
    }


    private String getToken(String encodedSecret, JwtUser jwtUser) {
        Date now = new Date();
        return Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setSubject(jwtUser.getEmail())
                .claim("role", jwtUser.getRole())
                .setIssuedAt(now)
                .setExpiration(getExpirationTime())
                .signWith(SignatureAlgorithm.HS512, encodedSecret)
                .compact();
    }
}