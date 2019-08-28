package com.betting.application.betting.service;

import com.betting.application.betting.client.BackendClient;
import com.betting.application.betting.domain.BetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

public class BetService {

    private BackendClient backendClient = BackendClient.getInstance();
    private static BetService betService;

    public static BetService getInstance(){
        if(betService == null) {
            betService = new BetService();
        }
        return betService;
    }

    public List<BetDto> getBets(){
        List<BetDto> betDtos = Arrays.asList(backendClient.getAvailableBets());
        betDtos.stream().forEach(betDto -> System.out.println(betDto.toString()));
        return betDtos;
    }
}
