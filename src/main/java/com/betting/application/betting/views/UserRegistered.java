package com.betting.application.betting.views;

import com.betting.application.betting.MainView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class UserRegistered extends VerticalLayout {
    private Button backToHomepage = new Button("back to homepage");
    private Button login = new Button("login");
    public UserRegistered(){
        Div div = new Div();
        div.setText("Congratulations, user registered");
        HorizontalLayout buttons = new HorizontalLayout();
        buttons.add(backToHomepage, login);
        backToHomepage.addClickListener(e -> UI.getCurrent().navigate(MainView.class));
        login.addClickListener(e -> UI.getCurrent().navigate(LoginView.class));
        add(div, buttons);
    }
}
