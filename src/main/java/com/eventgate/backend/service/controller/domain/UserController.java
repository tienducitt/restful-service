package com.eventgate.backend.service.controller.domain;

import com.eventgate.backend.service.dto.ActionResponse;
import com.eventgate.backend.service.dto.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "Get user by id", response = UserDTO.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Create user success"),
        @ApiResponse(code = 404, message = "User not exist"),
    })
    @GetMapping(value = "{userId}")
    public UserDTO get(@PathVariable int userId) {
        return new UserDTO();
    }

    @ApiOperation(value = "Create new user", response = ActionResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Create user success"),
            @ApiResponse(code = 400, message = "Validate error"),
    })
    @PostMapping
    public ActionResponse create(@Valid @RequestBody UserDTO user) {
        return ActionResponse.success("Create user success");
    }

    @ApiOperation(value ="Update user", response =  ActionResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Update user success"),
            @ApiResponse(code = 400, message = "Validate error"),
            @ApiResponse(code = 404, message = "User not exist"),
    })
    @PutMapping(value = "{userId}")
    public ActionResponse update(@PathVariable int userId, @Valid @RequestBody UserDTO user) {
        return ActionResponse.success("Update success");
    }

    @ApiOperation(value ="Delete user", response = ActionResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Delete user success"),
            @ApiResponse(code = 400, message = "Validate error"),
            @ApiResponse(code = 404, message = "User not exist"),
    })
    @DeleteMapping(value = "{userId}")
    public ActionResponse delete(@PathVariable int userId) {
        return ActionResponse.success("Delete success");
    }
}
