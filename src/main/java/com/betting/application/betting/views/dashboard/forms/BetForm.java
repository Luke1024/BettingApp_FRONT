package com.betting.application.betting.views.dashboard.forms;

import com.betting.application.betting.MainView;
import com.betting.application.betting.domain.BetPlacerDto;
import com.betting.application.betting.domain.SportEventDto;
import com.betting.application.betting.domain.utilities.Result;
import com.betting.application.betting.views.dashboard.views.BetsPlacer;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.data.binder.Binder;


public class BetForm extends FormLayout {
    private ComboBox<Result> result = new ComboBox<>("Result");
    private NumberField amount = new NumberField("Amount");
    private Button betPlacer = new Button("Place bet");
    private Button cancel = new Button("Cancel");

    private BetsPlacer betsPlacer;

    private Binder<BetPlacerDto> binder = new Binder<>(BetPlacerDto.class);

    public BetForm(BetsPlacer betsPlacer) {
        result.setItems(Result.values());
        HorizontalLayout buttons = new HorizontalLayout();

        binder.bindInstanceFields(this);

        betPlacer.addClickListener(e -> save());
        cancel.addClickListener(e -> cancel());


        buttons.add(betPlacer, cancel);
        buttons.setSizeFull();

        add(result, amount, buttons);
        setVisible(false);
    }

    private void save(){
        BetPlacerDto betPlacerDto = binder.getBean();
        Notification.show("Bet placed").setPosition(Notification.Position.MIDDLE);
        System.out.println(betPlacerDto.toString());
    }

    private void cancel(){
        setVisible(false);
    }

    public void setBet(SportEventDto sportEventDto){
        setVisible(true);
        binder.setBean(getMatchId(sportEventDto));
    }

    private BetPlacerDto getMatchId(SportEventDto sportEventDto){
        if(sportEventDto==null){
            setVisible(false);
            return new BetPlacerDto();
        } else {
            return new BetPlacerDto(1L, sportEventDto.getMatch_id(), 0, Result.DRAW);
        }
    }
}
