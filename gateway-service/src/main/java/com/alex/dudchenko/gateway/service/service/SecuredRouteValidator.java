package com.alex.dudchenko.gateway.service.service;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SecuredRouteValidator {

    private static final List<String> notSecured = List.of(
            "/auth/doctors/registration",
            "/auth/patients/registration",
            "/auth/login",
            "/auth/refresh",
            "/hospitals",
            "/specialisations"
    );

    public boolean isSecured(String path) {
        return notSecured.stream()
                .noneMatch(openPath -> openPath.matches(path));
    }
}
