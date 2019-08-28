package com.betting.application.betting.views;

import com.betting.application.betting.MainView;
import com.betting.application.betting.domain.UserDto;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Route
public class RegistrationView extends VerticalLayout {

    private TextField firstname = new TextField("Firstname");
    private TextField lastname = new TextField("Lastname");
    private TextField password = new TextField("Password");
    private TextField email = new TextField("Email");

    private Button registerButton = new Button("Register");
    private Button backToHomePage = new Button("back to home page");
    private Binder<UserDto> binder = new Binder<>(UserDto.class);

    public RegistrationView() {
        binder.bindInstanceFields(this);
        binder.setBean(new UserDto());
        FormLayout formLayout = new FormLayout();
        HorizontalLayout buttons = new HorizontalLayout(registerButton, backToHomePage);
        formLayout.add(firstname, lastname, password, email ,buttons);
        registerButton.addClickListener(event -> performRegistration(binder.getBean()));
        backToHomePage.addClickListener(e -> UI.getCurrent().navigate(MainView.class));
        add(formLayout);
    }

    private void performRegistration(UserDto user) {
        System.out.println(user.getFirstname());
        sendingUserToBackEnd(user);
        binder.setBean(null);
        UI.getCurrent().navigate(UserRegistered.class);
    }

    private void sendingUserToBackEnd(UserDto user){
        RestTemplate restTemplate = new RestTemplate();

        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/betting/users")
                .build().encode().toUri();
        restTemplate.postForObject(url, user, String.class);
    }
/*
    public void setUser(UserDto user){
        binder.setBean(user);

        if(user == null) {
            setVisible(false);
        } else {
            setVisible(true);
        }
    }
    */
}
