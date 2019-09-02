package com.betting.application.betting.views.dashboard;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.atmosphere.interceptor.AtmosphereResourceStateRecovery;

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

    public DashBoard() {
        VerticalLayout menu = new VerticalLayout(home, myAccount, myBets, myBettingHistory ,placeBets, moneyTransfer, transferHistory, allTransactionHistory, logout);
        add(menu);
    }
}
