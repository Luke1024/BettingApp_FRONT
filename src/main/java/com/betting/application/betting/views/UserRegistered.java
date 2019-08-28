package com.betting.application.betting.views;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route
public class UserRegistered extends Div {
    public UserRegistered(){
        setText("Congratulations, user registered");
    }
}
