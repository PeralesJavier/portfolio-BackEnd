package com.portfolio.jlpc.Security.jwt;

//Se va a ejecutar por cada peticion; va a comprobar que sea valido el token utilizacon el JwtProvider

import com.portfolio.jlpc.Security.service.UserDetailsServiceImpl;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

//En caso que sea valido el token va a permitir el acceso al recurso
//en caso contrario lanzara la excepcion

public class JwtTokenFilter extends OncePerRequestFilter{
    
    private final static Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);
    @Autowired
    JwtProvider JwtProvider;
    
    @Autowired
    UserDetailsServiceImpl userDetailsService;
            
    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
        //se ejecuta una vez por cada peticion; comprueba que el token es valido
        //utilizando al provider
        try {
            String token = getToken(req);
            if(token != null && JwtProvider.validateToken(token)){
                String nombreUsuario = JwtProvider.getNombreUsuarioFromToken(token);
                UserDetails userDetails = userDetailsService.loadUserByUsername(nombreUsuario);
                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(userDetails, null, 
                        userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch(Exception e){
            logger.error("fail en el metodo doFilter");
        }
        filterChain.doFilter(req, res);
    }
    
    private String getToken(HttpServletRequest request){
        String header = request.getHeader(ALREADY_FILTERED_SUFFIX);
        if(header != null && header.startsWith("Bearer"))
            return header.replace("Bearer", "");
        return null;
    }
    
}
