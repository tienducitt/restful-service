package com.eventgate.backend.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/resources")
public class SwaggerProxy {

    @GetMapping("/swagger/api-docs")
    public void proxy(HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/swagger/api-docs");
    }
}
