package com.betting.application.betting.client;

import com.betting.application.betting.config.ApiConfig;
import com.betting.application.betting.domain.BetDto;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class BackendClient {

    private ApiConfig apiConfig = ApiConfig.getInstance();

    private RestTemplate restTemplate = new RestTemplate();

    private static BackendClient backendClient;

    public static BackendClient getInstance(){
        if(backendClient == null) {
            backendClient = new BackendClient();
        }
        return backendClient;
    }

    public BetDto[] getAvailableBets(){
        URI url = UriComponentsBuilder.fromHttpUrl(apiConfig.getBettingApiEndpoint() + apiConfig.getBettingEndpoint())
                .build().encode().toUri();

        System.out.println(url);

        return restTemplate.getForObject(url, BetDto[].class);
    }
}
