package com.eventgate.backend.service.service;

import com.eventgate.backend.service.model.User;
import com.eventgate.backend.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public boolean authenticate(String email, String password) {
        User user = userRepository.findByEmail(email);
        return user != null && password.equals(user.getPassword());
    }
}
