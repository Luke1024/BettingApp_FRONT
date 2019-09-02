package com.betting.application.betting.views.dashboard;

import com.betting.application.betting.MainView;
import com.betting.application.betting.service.SportEventService;
import com.betting.application.betting.views.dashboard.views.*;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class DashBoard extends VerticalLayout {
    private Button home = new Button("Home");
    private Button myAccount = new Button("My account");
    private Button myBets = new Button("My active bets");
    private Button myBettingHistory = new Button("My betting history");
    private Button placeBets = new Button("Place bets");
    private Button moneyTransfer = new Button("Transfer money");
    private Button transferHistory = new Button("Money transfer history");
    private Button allTransactionHistory = new Button("All transaction history");
    private Button logout = new Button("Log out");

    private SportEventService sportEventService = SportEventService.getInstance();
    //private Grid<SportEventDto> grid = new Grid<>(SportEventDto.class);

    private AvailableBets availableBets = new AvailableBets();
    private BetsPlacer betsPlacer = new BetsPlacer();
    private ActiveBets activeBets = new ActiveBets();
    private BettingHistory bettingHistory = new BettingHistory();
    private UserAccount userAccount = new UserAccount();

    public DashBoard() {
        HorizontalLayout menu = new HorizontalLayout(home, placeBets, myBets, myBettingHistory, myAccount, logout);
        add(menu);
        home.addClickListener(e -> availableBets.setVisible(true));
        placeBets.addClickListener(e -> setVisibilityOfBetsPlacer());
        myBets.addClickListener(e -> setVisibilityOfActiveBets());
        myBettingHistory.addClickListener(e -> setVisibilityOfBettingHistory());
        myAccount.addClickListener(e -> UI.getCurrent().navigate(UserAccount.class));
        logout.addClickListener(e -> UI.getCurrent().navigate(MainView.class));

        add(menu, availableBets, betsPlacer, activeBets, myBettingHistory, userAccount); //sportEvents);

        startDashBoardVisibility();
    }

    private void startDashBoardVisibility(){
        availableBets.setVisible(true);
        betsPlacer.setVisible(false);
        activeBets.setVisible(false);
        myBettingHistory.setVisible(false);
    }

    private void setVisibilityOfBetsPlacer(){
        availableBets.setVisible(false);
        betsPlacer.setVisible(true);
        activeBets.setVisible(false);
        myBettingHistory.setVisible(false);
    }

    private void setVisibilityOfActiveBets(){
        availableBets.setVisible(false);
        betsPlacer.setVisible(false);
        activeBets.setVisible(true);
        myBettingHistory.setVisible(false);
    }

    private void setVisibilityOfBettingHistory(){
        availableBets.setVisible(false);
        betsPlacer.setVisible(false);
        activeBets.setVisible(false);
        myBettingHistory.setVisible(true);
    }
}
