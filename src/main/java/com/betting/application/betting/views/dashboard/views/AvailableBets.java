package com.betting.application.betting.views.dashboard.views;

import com.betting.application.betting.domain.SportEventDto;
import com.betting.application.betting.service.SportEventService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class AvailableBets extends VerticalLayout {
    private SportEventService sportEventService = SportEventService.getInstance();
    private Grid<SportEventDto> grid = new Grid<>(SportEventDto.class);

    public AvailableBets() {
        grid.setColumns("country_name", "league_name", "match_date_time", "match_hometeam_name", "match_awayteam_name", "odd_1", "odd_x", "odd_2", "match_status");
        grid.setItems(sportEventService.getSportEvents());
        add(grid);
        setSizeFull();
    }
}
