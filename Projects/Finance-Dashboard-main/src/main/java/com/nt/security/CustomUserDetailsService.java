package com.nt.security;

import com.nt.constants.UserStatus;
import com.nt.model.User;
import com.nt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        log.debug("Login attempt for email: {}", email);

        // Step 1 - Find user by email
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> {
                    log.warn("Login failed - email not found: {}", email);
                    return new UsernameNotFoundException("Invalid credentials");
                });

        // Step 2 - Check if user is soft deleted
        if (Boolean.TRUE.equals(user.getIsDeleted())) {
            log.warn("Login failed - account deleted: {}", email);
            throw new UsernameNotFoundException("Invalid credentials");
        }

        // Step 3 - Check if user is active
        if (user.getStatus() == UserStatus.INACTIVE) {
            log.warn("Login failed - account inactive: {}", email);
            throw new DisabledException("Your account is inactive. Contact administrator.");
        }

        // Step 4 - Check role is not null
        if (user.getRole() == null) {
            log.error("Login failed - no role assigned to user: {}", email);
            throw new UsernameNotFoundException("User has no role assigned");
        }

        // Step 5 - Build role with ROLE_ prefix
        // Spring Security hasRole("ADMIN") internally looks for "ROLE_ADMIN"
        String role = "ROLE_" + user.getRole().getName().name();
        log.info("Login successful - email: {} | role: {}", email, role);

        // Step 6 - Return Spring Security UserDetails
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority(role))
        );
    }
}