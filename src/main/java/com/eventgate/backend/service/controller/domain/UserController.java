package com.eventgate.backend.service.controller.domain;

import com.eventgate.backend.service.controller.Response;
import com.eventgate.backend.service.controller.RespFactory;
import com.eventgate.backend.service.dto.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/v1/users")
@Api(description = "User controller")
public class UserController {

    @ApiOperation(value = "Get user by id")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Get user successfully"),
        @ApiResponse(code = 404, message = "User does not exist"),
    })
    @GetMapping(value = "{userId}")
    public Response<UserDTO> get(@PathVariable int userId) {
        return RespFactory.success(new UserDTO());
    }

    @ApiOperation(value = "Create new user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Create user successfully"),
            @ApiResponse(code = 404, message = "User does not exist"),
    })
    @PostMapping
    public Response create(@Valid @RequestBody UserDTO user) {
        return RespFactory.success("Create user successfully");
    }


    @ApiOperation(value ="Update user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Update user successfully"),
            @ApiResponse(code = 400, message = "Validate error"),
            @ApiResponse(code = 404, message = "User does not exist"),
    })
    @PutMapping(value = "{userId}")
    public Response update(@PathVariable int userId, @Valid @RequestBody UserDTO user) {
        return RespFactory.success("Update successfully");
    }


    @ApiOperation(value ="Delete user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Delete user successfully"),
            @ApiResponse(code = 400, message = "Validate error"),
            @ApiResponse(code = 404, message = "User does not exist"),})
    @DeleteMapping(value = "{userId}")
    public Response delete(@PathVariable int userId) {
        return RespFactory.fail(HttpStatus.NOT_FOUND, "User does not exist");
    }
}
