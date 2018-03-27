package com.eventgate.backend.service.controller.api;

import com.eventgate.backend.service.controller.HttpException;
import com.eventgate.backend.service.dto.AuthDTO;
import com.eventgate.backend.service.dto.JwtUser;
import com.eventgate.backend.service.service.JwtService;
import com.eventgate.backend.service.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthenController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtService jwtService;

    @ApiOperation("Login")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 502, message = "Not accepted")})
    @PostMapping
    public String auth(@RequestBody @Valid AuthDTO auth) {
        if (userService.authenticate(auth.getUsername(), auth.getPassword())) {
            return jwtService.getToken(new JwtUser(auth.getUsername(), "ADMIN"));
        }

        throw new HttpException(HttpStatus.UNAUTHORIZED);
    }
}
