package no.ntnu.sjakkskjerm.auth.security.jwt;

import io.jsonwebtoken.*;
import no.ntnu.sjakkskjerm.auth.security.services.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.security.Signature;
import java.util.Date;

@Component
public class JWTUtils {
    private static final Logger logger = LoggerFactory.getLogger(JWTUtils.class);

    private String jwtSecret = "toppHemmeligKeyHer";

    private int jwtExpirationTime = 86400000;

    public String generateJwtToken(Authentication authentication) {
        UserDetailsImpl authenticationPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject((authenticationPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationTime))
                .claim("uid", authenticationPrincipal.getUserId())
                .claim("username", authenticationPrincipal.getUsername())
                .claim("club", authenticationPrincipal.getClub())
                .claim("role", authenticationPrincipal.getAuthorities())
                .claim("email", authenticationPrincipal.getEmail())
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUserNameFromToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }


}
