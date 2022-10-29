package com.portfolio.jlpc.Security.jwt;

//Va a comprobar si hay un token valido; sino devuelve una respuesta 401 no autorizado

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;


@Component
public class JwtEntryPoint implements AuthenticationEntryPoint{

    //layer utilizado en desarrollo para ver el metodo que este dando error
    //en caso que la app no funcione
    private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);
    
    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException authException) throws IOException, ServletException {
        //aca lanzamos el error
        //Esto solo se utiliza en el desarrollo cuando la app esta lista no hay que tenerlo
        logger.error("Fail en el metodo commence ");
        // el res envia un error; rechaza todas las peticiones que no esten autenticadas
        //rechaza todas las peticiones que no esten autenticadas, manda SC_UNAUTHORIZED
        res.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }
    
}
