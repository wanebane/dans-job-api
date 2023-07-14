package com.rivaldy.dans.dto.pattern;

public record JwtSecret(String secretKey, long expirationToken, long refreshToken) {
}
