package com.alex.dudchenko.auth.service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Builder
public class UserCredentials {

    @Id
    @GeneratedValue(generator = "user_credentials_seq")
    @SequenceGenerator(name = "user_credentials_seq", sequenceName = "user_credentials_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String hashedPassword;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private Long profileId;
}
