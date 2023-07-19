package com.example.InternshipProject.View;


import com.example.InternshipProject.Controller.FlightController;
import com.example.InternshipProject.Controller.ReservationController;
import com.example.InternshipProject.Controller.UserController;
import com.example.InternshipProject.Repository.FlightRepository;
import com.example.InternshipProject.Repository.ReservationRepository;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.atmosphere.interceptor.AtmosphereResourceStateRecovery;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;

@PageTitle("Payment Page")
@Route("/payment")
public class PaymentView extends MainLayoutView implements  ViewInterface{
    @Autowired
    FlightController flightController;


    RadioButtonGroup cash;
    public PaymentView(FlightController flightController,ReservationController reservationController,  UserController userController){

        super(userController,reservationController);
        this.flightController = flightController;

        VerticalLayout layout = new VerticalLayout();
        Div maindiv =new Div();
        H1 PNR = new H1("PNR NUMBER: "+ AvailableFlightView.PNR);
        PNR.getStyle().set("position","relative");
        PNR.getStyle().set("font-size","12px");
        PNR.getStyle().set("left","500px");

        H1 flightinfos =new H1(flightController.findAircraft(SelectPortsView.selectarrival.getValue())+ " "+
                SelectPortsView.selectdeparture.getValue() +"-"+ SelectPortsView.selectarrival.getValue()+ " " + SelectPortsView.datePicker.getValue());
        flightinfos.getStyle().set("font-size","20px");

        Div flightinfo = new Div();;
        flightinfo.getStyle().set("position","relative");
        flightinfo.setText("Flight Info");

        flightinfo.getStyle().set("text-align","left");
        flightinfo.getStyle().set("font-weight","bold");
        flightinfo.setWidth("500px");
        flightinfo.setHeight("100px");
        flightinfo.getStyle().set("border", "2px solid black");
        flightinfo.getStyle().set("background-color", "blanchedalmond");
        flightinfo.getStyle().set("left","500px");
        flightinfo.add(flightinfos);



        H1 passengerinfos = new H1(PassengerinfoView.name.getValue()+ "            "+PassengerinfoView.surname.getValue()
                +"            "+PassengerinfoView.datePicker.getValue() +"            " + PassengerinfoView.gender.getValue());

        passengerinfos.getStyle().set("font-size","20px");

        Div passengerinfo = new Div();;
        passengerinfo.getStyle().set("position","relative");
        passengerinfo.setText("Passenger Info");
        passengerinfo.getStyle().set("text-align","left");
        passengerinfo.getStyle().set("font-weight","bold");
        passengerinfo.setWidth("500px");
        passengerinfo.setHeight("100px");
        passengerinfo.getStyle().set("border", "2px solid black");
        passengerinfo.getStyle().set("background-color", "blanchedalmond");
        passengerinfo.getStyle().set("left","500px");
        passengerinfo.getStyle().set("bottom", " -2px");
        passengerinfo.add(passengerinfos);


        Div payment = new Div();



         cash = new RadioButtonGroup<>();
        cash.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
        cash.setItems("CASH");

        Button OK = new Button("OK");
        OK.getStyle().set("position","relative");
        OK.getStyle().set("left","500px");
        OK.addThemeVariants(ButtonVariant.LUMO_PRIMARY,
                ButtonVariant.LUMO_SUCCESS);
       OK.getStyle().set("border-radius", "0 12rem 12rem 12rem");
       OK.getStyle().set("border","2px solid black");
       OK.addClickListener(buttonClickEvent -> control());


        payment.getStyle().set("position","relative");
        payment.setText("TOTAL PAYMENT: "+ AvailableFlightView.priceGroup.getValue());
        payment.getStyle().set("text-align","Center");
        payment.getStyle().set("font-weight","bold");
        payment.setWidth("500px");
        payment.setHeight("100px");
        payment.getStyle().set("border", "2px solid black");
        payment.getStyle().set("background-color", "khaki");
        payment.getStyle().set("left","500px");
        payment.getStyle().set("bottom", " -20px");
        payment.getStyle().set("border-radius","13px");


        payment.add(cash);

        maindiv.add(PNR,flightinfo,passengerinfo,payment,OK);

        layout.add(maindiv);
        this.setContent(layout);
    }

    public void control(){
        if(cash.isEmpty()){
            Notification notification = Notification.show("You need to choose payment method");
            notification.addThemeVariants(NotificationVariant.LUMO_WARNING);
        }else {
            reservationController.setStatus(AvailableFlightView.PNR);
            PnrSearchView.pnrfield = null;
            UI.getCurrent().navigate(ReservationInfoView.class);
        }
    }
}
