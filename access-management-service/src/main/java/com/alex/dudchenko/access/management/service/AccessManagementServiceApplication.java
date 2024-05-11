package com.alex.dudchenko.access.management.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AccessManagementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccessManagementServiceApplication.class, args);
    }

}
