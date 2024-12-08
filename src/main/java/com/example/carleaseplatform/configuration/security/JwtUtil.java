package com.example.carleaseplatform.configuration.security;

import io.jsonwebtoken.*;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
  private final Key key = new SecretKeySpec("a-very-secure-key-at-least-32-characters".getBytes(), "HmacSHA256");
  private final long expirationMs = 3600000; // 1 hour

  public String generateToken(String username) {
    return Jwts.builder()
        .setSubject(username)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
        .signWith(key)
        .compact();
  }

  public boolean validateToken(String token) {
    try {
      Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
      return true;
    } catch (JwtException e) {
      return false;
    }
  }

  public String getUsernameFromToken(String token) {
    Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    return claims.getSubject();
  }
}

