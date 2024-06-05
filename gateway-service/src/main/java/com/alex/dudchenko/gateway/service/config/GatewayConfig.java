package com.alex.dudchenko.gateway.service.config;

import com.alex.dudchenko.gateway.service.filters.AuthenticationFilter;
import lombok.AllArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class GatewayConfig {

    private final AuthenticationFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-profile-service",
                        r -> r.path(
                                        "/doctors/**",
                                        "/patients/**",
                                        "/hospitals/**",
                                        "/specialisations/**"
                                )
                                .filters(f -> f.filter(filter))
                                .uri("lb://user-profile-service")
                )
                .route("auth-service",
                        r -> r.path(
                                        "/auth/**"
                                )
                                .filters(f -> f.filter(filter))
                                .uri("lb://auth-service")
                )
                .route("medical-record-service",
                        r -> r.path(
                                        "/records/**",
                                        "/entries/**",
                                        "/access-records/**",
                                        "/access-requests/**",
                                        "/prescriptions/**",
                                        "/vaccinations/**",
                                        "/referrals/**"
                                )
                                .filters(f -> f.filter(filter))
                                .uri("lb://medical-record-service")
                )
                .build();
    }
}
