package com.kfss.TaskManagementSystem.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtUtil {

	private static final String SECRET_KEY = "kkkkfkKKKKKDKDKD9339994949494949FKEKEK4II449KDK"; // Deve ter no mínimo 32
																								// caracteres
	private final Key key = Keys.hmacShaKeyFor(Base64.getEncoder().encode(SECRET_KEY.getBytes()));

	private final long expirationMs = 86400000; // 24 horas.

	// Gerar o Token
	public String generateToken(String username) {
		return Jwts.builder().setSubject(username).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + expirationMs))
				.signWith(key, SignatureAlgorithm.HS256).compact();
	}

	// Validar o Token
	public boolean validateToken(String token) {
		try {
			Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
			return true;
		} catch (JwtException | IllegalArgumentException e) {
			return false;
		}
	}

	// Extrair o Usuário do Token
	public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        }
}