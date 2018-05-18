package com.eventgate.backend.service.controller.api.v1;

import com.eventgate.backend.service.exception.EntityNotFoundException;
import com.eventgate.backend.service.exception.HttpException;
import com.eventgate.backend.service.model.User;
import com.eventgate.backend.service.repository.TeamRepository;
import com.eventgate.backend.service.repository.UserRepository;
import com.eventgate.backend.service.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users")
@Api(description = "User controller")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    UserService userService;

    @ApiOperation(value = "Get list users")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success")
    })
    @GetMapping()
    public List<User> getAll() {
        return userRepository.findAll();
    }


    @ApiOperation(value = "Get user by id")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Get user successfully"),
        @ApiResponse(code = 404, message = "User does not exist"),
    })
    @GetMapping(value = "{userId}")
    public User get(@PathVariable int userId) {
        return userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException(User.class, "id", userId));
    }

    @ApiOperation(value = "Create new user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Create user successfully"),
            @ApiResponse(code = 404, message = "User does not exist"),
    })
    @PostMapping
    public User create(@Valid @RequestBody User dto) {
        User user = userRepository.findByEmail(dto.getEmail());
        if (user != null) {
            throw new HttpException(HttpStatus.BAD_REQUEST, "Email is already used");
        }

        return userService.save(dto);
    }


    @ApiOperation(value ="Update user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Update user successfully"),
            @ApiResponse(code = 400, message = "Validate error"),
            @ApiResponse(code = 404, message = "User does not exist"),
    })
    @PutMapping(value = "{userId}")
    public User update(@PathVariable int userId, @Valid @RequestBody User input) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException(User.class, "id", userId));
        user.setDisplayName(input.getDisplayName());
        user.setAvatar(input.getAvatar());
        user.setPassword(input.getPassword());

        return  userRepository.save(user);    //TODO: what happen if it fail?
    }


    @ApiOperation(value ="Delete user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Delete user successfully"),
            @ApiResponse(code = 400, message = "Validate error"),
            @ApiResponse(code = 404, message = "User does not exist"),})
    @DeleteMapping(value = "{userId}")
    public User delete(@PathVariable int userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException(User.class, "id", userId));
        userRepository.delete(user);    //TODO: what happen if it fail?

        return user;
    }
}
