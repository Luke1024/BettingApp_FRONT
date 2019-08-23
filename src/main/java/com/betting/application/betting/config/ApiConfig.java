package com.betting.application.betting.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApiConfig {
    @Value("http://localhost:8080")
    private String bettingApiEndpoint;

    public String getBettingApiEndpoint() {
        return bettingApiEndpoint;
    }
}
