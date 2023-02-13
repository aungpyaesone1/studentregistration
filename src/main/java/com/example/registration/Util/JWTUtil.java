package com.example.registration.Util;

import com.example.registration.Config.JwtTokenFilter;
import com.example.registration.Dao.UserDao;
import com.example.registration.Dto.UserPrinciple;
import com.example.registration.Entity.User;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class JWTUtil {
    public static long JWT_TOKEN_VALIDITY = (long) (60 * 60 * 1000);
    private static final String jwtSecret = "d5a99db8326bd1ca05e781a0dc9387715706cf5b09364f4a2e983a86216959ba";
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);
    @Autowired
    private UserDao userDao;

    public String generateJwtToken(String userid) {
        Optional<User> user = userDao.findByUserid(userid);
        return Jwts.builder()
                .claim("syskey", user.get().getSyskey())
                .claim("userid", user.get().getUserid())
                .claim("username", user.get().getUsername())
                .claim( "roles", user.get().getRoles())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + JWT_TOKEN_VALIDITY))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public UserPrinciple validateJwtToken(String authToken) {
        UserPrinciple userPrinciple = new UserPrinciple();
        try {
            Jws<Claims> jwtClaims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            userPrinciple.setSyskey(jwtClaims.getBody().get("syskey",Long.class));
            userPrinciple.setUserid(jwtClaims.getBody().get("userid", String.class));
            userPrinciple.setUsername(jwtClaims.getBody().get("username", String.class));
            userPrinciple.setRoles(jwtClaims.getBody().get("roles", List.class));
        }  catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }
        return userPrinciple;
    }
}
