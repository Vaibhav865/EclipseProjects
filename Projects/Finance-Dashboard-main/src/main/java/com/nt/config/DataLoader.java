package com.nt.config;

import com.nt.constants.RoleName;
import com.nt.constants.UserStatus;
import com.nt.model.Role;
import com.nt.model.User;
import com.nt.repository.RoleRepository;
import com.nt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        // Set SYSTEM auth so auditing captures created_by = SYSTEM
        SecurityContextHolder.getContext().setAuthentication(
            new UsernamePasswordAuthenticationToken(
                "SYSTEM", null, Collections.emptyList()
            )
        );

        // Step 1 - Seed roles
        Role adminRole = seedRole(RoleName.ADMIN);
        seedRole(RoleName.ANALYST);
        seedRole(RoleName.VIEWER);

        // Step 2 - Seed default admin user if no users exist
        if (userRepository.count() == 0) {
            User admin = User.builder()
                    .fullName("Super Admin")
                    .email("admin@finance.com")
                    .password(passwordEncoder.encode("Admin@123"))
                    .status(UserStatus.ACTIVE)
                    .role(adminRole)
                    .build();

            userRepository.save(admin);
            log.info("================================================");
            log.info("  Default admin user created successfully");
            log.info("  Email    : admin@finance.com");
            log.info("  Password : Admin@123");
            log.info("================================================");
        } else {
            log.info("Users already exist - skipping default admin creation");
        }

        // Clear security context after seeding
        SecurityContextHolder.clearContext();
    }

    private Role seedRole(RoleName roleName) {
        return roleRepository.findByName(roleName)
                .orElseGet(() -> {
                    Role role = roleRepository.save(
                        Role.builder().name(roleName).build()
                    );
                    log.info("Role created: {}", roleName);
                    return role;
                });
    }
}