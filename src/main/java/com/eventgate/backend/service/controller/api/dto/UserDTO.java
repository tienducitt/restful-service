package com.eventgate.backend.service.controller.api.dto;

import com.eventgate.backend.service.model.Role;
import com.eventgate.backend.service.model.User;
import lombok.Data;

@Data
public class UserDTO {
    private int id;
    private String email;
    private String displayName;
    private String avatar;
    private Role role;

    public UserDTO(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.displayName = user.getDisplayName();
        this.avatar = user.getAvatar();
        this.role = user.getRole();
    }
}
