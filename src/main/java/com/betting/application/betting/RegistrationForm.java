package com.betting.application.betting;

import com.betting.application.betting.config.ApiConfig;
import com.betting.application.betting.domain.User;
import com.google.gson.Gson;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import elemental.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class RegistrationForm extends FormLayout {

    private TextField firstname = new TextField("Firstname");
    private TextField lastname = new TextField("Lastname");
    private TextField password = new TextField("Password");
    private TextField email = new TextField("Email");

    private Button registerButton
            = new Button("Register");
    private Binder<User> binder = new Binder<>(User.class);

    private MainView mainView;

    public RegistrationForm(MainView mainView) {
        this.mainView = mainView;
        HorizontalLayout button = new HorizontalLayout(registerButton);
        add(firstname, lastname, password, email ,button);
        binder.bindInstanceFields(this);
        registerButton.addClickListener(event -> register());
    }

    private void register() {
        User user = binder.getBean();
        System.out.println(user.getFirstname() + " " + user.getLastname() + " " + user.getPassword() + " " + user.getEmail());
        sendingUserToFrontEnd(user);
        System.out.println("Show view about registration.");
        Notification.show("User registered");
        setUser(null);
    }

    private void sendingUserToFrontEnd(User user){
        RestTemplate restTemplate = new RestTemplate();
        Gson gson = new Gson();
        String json = gson.toJson(user);

        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/betting/users")
                .build().encode().toUri();

        //HttpHeaders headers = new HttpHeaders();
        //headers.setContentType(MediaType.APPLICATION_JSON);
        //HttpEntity<String> request = new HttpEntity<String>(json, headers);
        restTemplate.postForObject(url, user, String.class);
    }

    public void setUser(User user){
        binder.setBean(user);

        if(user == null) {
            setVisible(false);
        } else {
            setVisible(true);
        }
    }
}
