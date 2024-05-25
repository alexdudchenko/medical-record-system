package com.alex.dudchenko.auth.service.model.dto;

import lombok.Data;

@Data
public class RefreshRequest {

    private String accessToken;
    private String refreshToken;
}
