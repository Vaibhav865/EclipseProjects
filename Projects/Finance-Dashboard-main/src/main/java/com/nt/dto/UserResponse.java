package com.nt.dto;

import java.util.UUID;

import com.nt.constants.RoleName;
import com.nt.constants.UserStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private UUID uuid;
    private String fullName;
    private String email;
    private RoleName role;
    private UserStatus status;
}