package com.eventgate.backend.service.intercepter;

import com.eventgate.backend.service.config.Configuration;
import com.eventgate.backend.service.exception.HttpException;
import com.eventgate.backend.service.dto.JwtUser;
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
    private JwtService jwtService;

    @Value("${jwt.auth.header}")
    private String authHeader;

    @Autowired
    private Configuration configuration;

    @Override
    public boolean preHandle(HttpServletRequest req,
                             HttpServletResponse resp, Object arg2) throws HttpException {

        if (!configuration.isJwtAuthenEnable()) {
            return true;
        }

        //TODO: config addPatterns in not stable, I have to do it manually instead!
        String path = req.getRequestURI();
        if (!(path.startsWith("/api/v1/") || path.startsWith("/api/member/") || path.startsWith("/api/me"))) {
            return true;
        }

        String authHeaderVal = req.getHeader(authHeader);
        if (authHeaderVal == null) {
            throw new HttpException(HttpStatus.UNAUTHORIZED, "UnAuthorized");
        }

        try {
            JwtUser jwtUser = jwtService.getUser(authHeaderVal);
            req.setAttribute("jwtUser", jwtUser);
        } catch (JwtException ex) {
            throw new HttpException(HttpStatus.NOT_ACCEPTABLE, ex.getMessage());
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {}
}
