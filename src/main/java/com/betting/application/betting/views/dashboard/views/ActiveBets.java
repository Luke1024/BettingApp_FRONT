package com.betting.application.betting.views.dashboard.views;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class ActiveBets extends HorizontalLayout {

    public ActiveBets(){
        add(new Div(new Text("Thos is Active bets.")));
    }
}
