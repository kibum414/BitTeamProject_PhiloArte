package shop.parkkibeom.api.security.domain;

import io.jsonwebtoken.*;
import lombok.extern.java.Log;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Log
public class SecurityToken {
    private final String token;
    private final String key;
    private int tokenExpirationMsec = 1800000; // 만료시간 30분
    private static final String AUTHORITIES_KEY = "role";

    public SecurityToken(String key) {
        this.token = createToken();
        this.key = key;
    }

    public String createToken() {
        try {
            Map<String, Object> headers = new HashMap<>();
            headers.put("alg", "HS256");
            headers.put("typ", "JWT");

            Map<String, Object> payloads = new HashMap<>();
            payloads.put("data", "My First JWT");

            long expirationTime = 1000 * 60L * 60L * 2L; // 토큰 유효시간 2시간
            Date ext = new Date();
            ext.setTime(ext.getTime() * expirationTime);

            return Jwts
                    .builder()
                    .setHeader(headers)
                    .setClaims(payloads)
                    .setSubject("user") // 용도
                    .setExpiration(ext)
                    .signWith(SignatureAlgorithm.HS256, key.getBytes())
                    .compact()
                    ;
        } catch(SecurityException e) {
            log.info("Invalid JWT Signature");
        } catch(MalformedJwtException e) {
            log.info("Invalid JWT Token");
        } catch(ExpiredJwtException e) {
            log.info("Expiration JWT Token");
        } catch(UnsupportedJwtException e) {
            log.info("Unsupported JWT Signature");
        } catch(IllegalArgumentException e) {
            log.info("JWT Token compact of handler are invalid.");
        }

        // 어느 조건에도 안 걸리면 NullPointerException 에러 뜨게 함
        return null;
    }
}
