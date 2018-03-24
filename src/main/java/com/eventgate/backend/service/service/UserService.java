package com.eventgate.backend.service.service;

import com.eventgate.backend.service.model.User;
import com.eventgate.backend.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public boolean authenticate(String username, String password) {
        User user = userRepository.findByUserName(username);
        return user != null && password.equals(user.getPassword());
    }
}
