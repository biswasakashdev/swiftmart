package com.biswasakashdev.swiftmart.common.service;

import com.biswasakashdev.swiftmart.common.TokenType;
import com.biswasakashdev.swiftmart.common.exceptions.InvalidTokenTypeException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;

import java.time.Duration;
import java.util.Map;

public interface JwtService {

    String buildToken(String userId, Duration expiry, TokenType tokenType, Map<String,Object> extraClaims);

    String validate(String token,TokenType tokenType) throws ExpiredJwtException, MalformedJwtException, InvalidTokenTypeException;

    Claims extractAllClaims(String token) throws ExpiredJwtException, MalformedJwtException;

    <T> T extractClaim(String token, String key, Class<T> type);
}
