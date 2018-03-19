package com.eventgate.backend.service.controller;

import com.eventgate.backend.service.config.Configuration;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(value = "/hello")
@Api(value = "hello world lala", description = "This just a hello world controller")
public class HelloController {

    @Autowired
    Configuration config;

    @ApiOperation(value = "Just hello world example", notes = "This is operator notes", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource", response = String.class),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found tada")
    })
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World tada  " + config.getCompiler().getTimeout();
    }
}
