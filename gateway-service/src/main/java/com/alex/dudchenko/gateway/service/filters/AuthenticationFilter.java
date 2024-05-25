package com.alex.dudchenko.gateway.service.filters;

import com.alex.dudchenko.gateway.service.service.SecuredRouteValidator;
import com.alex.dudchenko.gateway.service.util.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class AuthenticationFilter implements GatewayFilter {

    private final SecuredRouteValidator securedRouteValidator;
    private final JwtUtils jwtUtils;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        if (!securedRouteValidator.isSecured(request.getURI().getPath())) {
            return chain.filter(exchange);
        }

        if (authMissing(request)) {
            return onError(exchange, HttpStatus.UNAUTHORIZED);
        }

        String token = request
                .getHeaders()
                .getOrEmpty("Authorization")
                .get(0)
                .substring("Bearer ".length() - 1);

        if (jwtUtils.isExpired(token)) {
            return onError(exchange, HttpStatus.UNAUTHORIZED);
        }

        return chain.filter(exchange);
    }

    private Mono<Void> onError(ServerWebExchange exchange, HttpStatus httpStatus) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(httpStatus);
        return response.setComplete();
    }

    private boolean authMissing(ServerHttpRequest request) {
        return !request.getHeaders().containsKey("Authorization");
    }
}
