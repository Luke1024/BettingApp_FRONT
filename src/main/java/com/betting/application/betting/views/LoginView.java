package com.betting.application.betting.views;

import com.betting.application.betting.MainView;
import com.betting.application.betting.domain.LoginDto;
import com.betting.application.betting.views.dashboard.DashBoard;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Route
public class LoginView extends VerticalLayout {

    private TextField email = new TextField("email");
    private TextField password = new TextField("password");

    private Button login = new Button("login");
    private Button backToHomePage = new Button("backToHomePage");

    private Binder<LoginDto> binder = new Binder<>(LoginDto.class);

    public LoginView(){
        binder.bindInstanceFields(this);
        binder.setBean(new LoginDto());
        FormLayout formLayout = new FormLayout();
        HorizontalLayout buttons = new HorizontalLayout(login, backToHomePage);
        formLayout.add(email, password, buttons);
        backToHomePage.addClickListener(e -> UI.getCurrent().navigate(MainView.class));
        login.addClickListener(e -> loginUser(binder.getBean()));
        add(formLayout);
    }

    private void loginUser(LoginDto loginDto){
        RestTemplate restTemplate = new RestTemplate();

        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/betting/users/login")
                .build().encode().toUri();

        Boolean loginResponse = restTemplate.postForObject(url, loginDto, Boolean.class);
        System.out.println(loginResponse);
        if(loginResponse==true){
            UI.getCurrent().navigate(DashBoard.class);
        } else {
            Notification.show("Password or email not correct");
        }
        binder.setBean(null);
    }
}
