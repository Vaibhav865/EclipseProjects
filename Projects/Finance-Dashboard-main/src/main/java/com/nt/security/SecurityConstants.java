package com.nt.security;

public class SecurityConstants {

    private SecurityConstants() {}

    public static final String ROLE_ADMIN   = "ADMIN";
    public static final String ROLE_ANALYST = "ANALYST";
    public static final String ROLE_VIEWER  = "VIEWER";

    public static final String[] PUBLIC_URLS = {
        "/actuator/health",
        "/v3/api-docs/**",
        "/swagger-ui/**",
        "/swagger-ui.html"
    };
}