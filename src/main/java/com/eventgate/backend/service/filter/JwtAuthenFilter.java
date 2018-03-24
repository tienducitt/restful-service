package com.eventgate.backend.service.filter;

import com.eventgate.backend.service.model.JwtUser;
import com.eventgate.backend.service.service.JwtService;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter(urlPatterns = {"/api/v1/*"})
public class JwtAuthenFilter implements Filter {

    @Autowired
    JwtService jwtService;

    @Value("${jwt.auth.header}")
    String authHeader;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        if (req.getRequestURI().startsWith("/api/v1")) {    // some how @WebFilter not work, I have to filter like this instead
            String authHeaderVal = req.getHeader(authHeader);

            if (authHeaderVal == null) {
                resp.setStatus(HttpStatus.UNAUTHORIZED.value());    //TODO: should have better response
                return;
            }

            try {
                JwtUser jwtUser = jwtService.getUser(authHeaderVal);
                req.setAttribute("jwtUser", jwtUser);
            } catch (JwtException ex) {
                resp.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
                return;
            }
        }

        filterChain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}
}
