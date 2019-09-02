package com.betting.application.betting.views.dashboard.views;

import com.betting.application.betting.domain.SportEventDto;
import com.betting.application.betting.service.SportEventService;
import com.betting.application.betting.views.dashboard.forms.BetForm;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class BetsPlacer extends HorizontalLayout {
    private SportEventService sportEventService = SportEventService.getInstance();
    private Grid<SportEventDto> grid = new Grid<>(SportEventDto.class);
    private BetForm betForm = new BetForm(this);

    public BetsPlacer(){
        grid.setColumns("country_name", "league_name", "match_date_time", "match_hometeam_name", "match_awayteam_name", "odd_1", "odd_x", "odd_2", "match_status");
        grid.setItems(sportEventService.getSportEvents());
        add(grid, betForm);
        setSizeFull();

        grid.asSingleSelect().addValueChangeListener(e -> betForm.setBet(grid.asSingleSelect().getValue()));
    }
}
