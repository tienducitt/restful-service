package com.eventgate.backend.service.intercepter;

import com.eventgate.backend.service.controller.HttpException;
import com.eventgate.backend.service.model.JwtUser;
import com.eventgate.backend.service.service.JwtService;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtAuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    JwtService jwtService;

    @Value("${jwt.auth.header}")
    String authHeader;

    @Override
    public boolean preHandle(HttpServletRequest req,
                             HttpServletResponse resp, Object arg2) throws Exception {
            String authHeaderVal = req.getHeader(authHeader);

            if (authHeaderVal == null) {
                throw new HttpException(HttpStatus.UNAUTHORIZED);
            }

            try {
                JwtUser jwtUser = jwtService.getUser(authHeaderVal);
                req.setAttribute("jwtUser", jwtUser);
            } catch (JwtException ex) {
                throw new HttpException(HttpStatus.NOT_ACCEPTABLE);
            }


        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
}
