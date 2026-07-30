package com.nt.service_interface;

import java.util.List;
import java.util.UUID;

import com.nt.dto.UserRequest;
import com.nt.dto.UserResponse;

public interface UserService {
    UserResponse createUser(UserRequest request);
    List<UserResponse> getAllUsers();
    UserResponse getUserById(UUID uuid);
    UserResponse updateUser(UUID uuid, UserRequest user);
    void deleteUser(UUID uuid);
}