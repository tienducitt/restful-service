package com.eventgate.backend.service.controller.api;

import com.eventgate.backend.service.controller.api.dto.UserDTO;
import com.eventgate.backend.service.exception.HttpException;
import com.eventgate.backend.service.controller.api.dto.AuthDTO;
import com.eventgate.backend.service.dto.JwtUser;
import com.eventgate.backend.service.model.User;
import com.eventgate.backend.service.repository.UserRepository;
import com.eventgate.backend.service.service.JwtService;
import com.eventgate.backend.service.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class AuthenController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtService jwtService;

    @ApiOperation("Login")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 502, message = "Not accepted")})
    @PostMapping("/auth")
    public String auth(@RequestBody @Valid AuthDTO auth) {
        if (userService.authenticate(auth.getEmail(), auth.getPassword())) {
            return jwtService.getToken(new JwtUser(auth.getEmail(), "ADMIN"));
        }

        throw new HttpException(HttpStatus.UNAUTHORIZED, "Email or password is not valid");
    }

    @GetMapping("/me")
    public UserDTO getMe(@RequestAttribute JwtUser jwtUser) {
        User user = userRepository.findByEmail(jwtUser.getEmail());
        if (user == null) {
            throw new HttpException(HttpStatus.UNAUTHORIZED, "Account is unactive or already removed");
        }

        return new UserDTO(user);
    }
}
