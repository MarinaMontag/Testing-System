package ua.knu.montag.spring.controllers.jwt;

import io.jsonwebtoken.*;
import ua.knu.montag.spring.controllers.exceptions.ServerException;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

import static ua.knu.montag.spring.controllers.jwt.SecurityConstants.*;

public class JWTConverter {
    public static String createJWT(String id, String subject){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        JwtBuilder builder = Jwts.builder().setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .signWith(signatureAlgorithm, signingKey);

            long expMillis = nowMillis + EXPIRATION;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);

        return builder.compact();
    }
    public static Claims decodeJWT(String jwt) throws ServerException {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET))
                    .parseClaimsJws(jwt).getBody();
            return claims;
        }catch (ExpiredJwtException | MalformedJwtException e){
            throw new ServerException("Unauthorized request");
        }
    }
}
