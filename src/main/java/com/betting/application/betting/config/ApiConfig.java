package com.betting.application.betting.config;

public class ApiConfig {
    private String bettingApiEndpoint = "http://localhost:8080";
    private String bettingEndpoint = "/betting/getAvailableSportEvents";

    private static ApiConfig apiConfig;

    public static ApiConfig getInstance(){
        if(apiConfig == null) {
            apiConfig = new ApiConfig();
        }
        return apiConfig;
    }

    public String getBettingApiEndpoint() {
        return bettingApiEndpoint;
    }

    public String getBettingEndpoint() {
        return bettingEndpoint;
    }
}
