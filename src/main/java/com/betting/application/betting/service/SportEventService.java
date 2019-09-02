package com.betting.application.betting.service;

import com.betting.application.betting.client.BackendClient;
import com.betting.application.betting.domain.SportEventDto;

import java.util.Arrays;
import java.util.List;

public class SportEventService {

    private BackendClient backendClient = BackendClient.getInstance();
    private static SportEventService sportEventService;

    public static SportEventService getInstance(){
        if(sportEventService == null) {
            sportEventService = new SportEventService();
        }
        return sportEventService;
    }

    public List<SportEventDto> getSportEvents(){
        List<SportEventDto> sportEventDtos = Arrays.asList(backendClient.getAvailableSportEvents());
        sportEventDtos.stream().forEach(sportEventDto -> System.out.println(sportEventDto.toString()));
        return sportEventDtos;
    }
}
