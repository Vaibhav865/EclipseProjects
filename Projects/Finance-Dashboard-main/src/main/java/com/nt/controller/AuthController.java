package com.nt.controller;

import com.nt.exception.ResourceNotFoundException;
import com.nt.model.User;
import com.nt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;

    // Login — returns email and password (masked)
    @GetMapping("/login")
    public ResponseEntity<?> login(Authentication authentication) {
        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return ResponseEntity.ok(Map.of(
            "message",  "Login successful",
            "name",user.getFullName(),
            "uuid",user.getUuid(),
            "email",    user.getEmail(),
            "role", user.getRole()
        ));
    }

    // Logout — returns only email
    @PostMapping("/logout")
    public ResponseEntity<?> logout(Authentication authentication) {
        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return ResponseEntity.ok(Map.of(
            "message", "Logged out successfully",
            "email",   user.getEmail()
        ));
    }

    // Current user — returns full info
    @GetMapping("/current-user")
    public ResponseEntity<?> getCurrentUser(Authentication authentication) {
        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return ResponseEntity.ok(Map.of(
            "uuid",      user.getUuid(),
            "fullName",  user.getFullName(),
            "email",     user.getEmail(),
            "role",      user.getRole().getName(),
            "status",    user.getStatus(),
            "createdAt", user.getCreatedAt(),
            "createdBy", user.getCreatedBy()
        ));
    }
}