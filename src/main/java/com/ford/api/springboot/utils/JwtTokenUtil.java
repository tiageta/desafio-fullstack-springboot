package com.ford.api.springboot.utils;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil {
    public String generateToken(String username) {
		return Jwts.builder().claim("username", username)
                .signWith(SignatureAlgorithm.HS512, "SOME_RANDOM_SECRET")
				.compact();
	}
    
}
