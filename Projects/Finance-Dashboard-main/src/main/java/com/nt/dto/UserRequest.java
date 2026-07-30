package com.nt.dto;

import com.nt.constants.RoleName;
import com.nt.constants.UserStatus;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class UserRequest {

    private String fullName;

    private String password;

    private String confirmPassword;

    @Email(message = "Invalid email format")
    private String email;

    private RoleName roleName;
    
    private UserStatus status;
}