package com.example.registration.Config;

import com.example.registration.Dto.UserPrinciple;
import com.example.registration.Util.JWTUtil;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JwtTokenFilter extends OncePerRequestFilter {
    @Autowired
    private JWTUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
            try {
                String authorizationHeader = request.getHeader("Authorization");
                if (authorizationHeaderIsInvalid(authorizationHeader)) {
                    filterChain.doFilter(request, response);
                    return;
                }
                String token = authorizationHeader.replace("Bearer ", "");
                UserPrinciple userPrincipal = jwtUtil.validateJwtToken(token);
                List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                userPrincipal.getRoles().forEach(role -> {
                    authorities.add(new SimpleGrantedAuthority("ROLE_"+role));
                });
                SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(userPrincipal, null, authorities));
                filterChain.doFilter(request, response);

            }
            catch (UnsupportedJwtException | MalformedJwtException e) {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                ((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
                return;
            }  catch (ExpiredJwtException e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token Expired");
                return;
            }

}
    private boolean authorizationHeaderIsInvalid(String authorizationHeader) {
        return authorizationHeader == null || !authorizationHeader.startsWith("Bearer ");
    }

}
