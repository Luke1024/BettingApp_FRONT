package com.betting.application.betting;

import com.betting.application.betting.domain.SportEventDto;
import com.betting.application.betting.service.SportEventService;
import com.betting.application.betting.views.LoginView;
import com.betting.application.betting.views.RegistrationView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    private SportEventService sportEventService = SportEventService.getInstance();
    private Grid<SportEventDto> grid = new Grid<>(SportEventDto.class);
    private Button register = new Button("Register");
    private Button logIn = new Button("Log in");


    public MainView() {
        grid.setColumns("country_name", "league_name", "match_date_time", "match_hometeam_name", "match_awayteam_name", "odd_1", "odd_x", "odd_2", "match_status");
        grid.setItems(sportEventService.getSportEvents());

        HorizontalLayout toolbar = new HorizontalLayout(register, logIn);
        HorizontalLayout content = new HorizontalLayout(grid);

        register.addClickListener(e -> {
            UI.getCurrent().navigate(RegistrationView.class);
        });

        logIn.addClickListener(e -> {
            UI.getCurrent().navigate(LoginView.class);
        });

        content.setSizeFull();
        add(toolbar ,content);
    }
}