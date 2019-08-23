package com.betting.application.betting;

import com.betting.application.betting.domain.User;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {
    private Button register = new Button("Register");
    private Button logIn = new Button("Log in");
    private RegistrationForm registrationForm = new RegistrationForm(this);

    public MainView() {
        register.addClickListener(e -> {
            registrationForm.setUser(new User());
            registerUser();
        });

        logIn.addClickListener(e -> {
            System.out.println("Enter dashboard");
        });

        HorizontalLayout mainContent = new HorizontalLayout(register, logIn);
        mainContent.setSizeFull();
        add(mainContent);
    }

    private void registerUser(){
        HorizontalLayout registerContent = new HorizontalLayout(registrationForm);
        add(registerContent);
    }
}