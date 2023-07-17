package com.example.InternshipProject.View;

import com.example.InternshipProject.Controller.FlightController;
import com.example.InternshipProject.Controller.ReservationController;
import com.example.InternshipProject.Controller.UserController;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;


@PageTitle("Available Flight")
@Route("/availableflight")

public class AvailableFlightView extends  MainLayoutView{

   @Autowired
  FlightController flightController;
   @Autowired
   ReservationController reservationController;
   @Autowired
    UserController userController;


  public static  RadioButtonGroup<String> priceGroup;




    public AvailableFlightView(FlightController service,ReservationController rescontrol){
        super();
        this.flightController = service;
        this.reservationController = rescontrol;

        H1 business = new H1("Business");
        business.getStyle().set("top","-375px");
        business.getStyle().set("right","-55px");
        business.getStyle().set("position","relative");
        business.getStyle().set("font-size","30px");

        H1 economoy = new H1("Economy");
        economoy.getStyle().set("top","-305px");
        economoy.getStyle().set("right","-55px");
        economoy.getStyle().set("position","relative");
        economoy.getStyle().set("font-size","30px");

        H1 flightinfo = new H1(flightController.findAircraft(SelectPortsView.selectarrival.getValue())+" | "
                + SelectPortsView.selectdeparture.getValue()+"-"+SelectPortsView.selectarrival.getValue()
                + " | "+SelectPortsView.datePicker.getValue());

        flightinfo.getStyle().set("top","-513px");
        flightinfo.getStyle().set("right","-115px");
        flightinfo.getStyle().set("position","relative");
        flightinfo.getStyle().set("font-size","20px");


        Div firstbox = new Div();;

        firstbox.getStyle().set("text-align","left");
        firstbox.setWidth("500px");
        firstbox.setHeight("100px");
        firstbox.getStyle().set("border", "1px solid black");
        firstbox.getStyle().set("background-color", "LightGreen");
        firstbox.getStyle().set("border-radius", "20px");


        Div infobox = new Div();
        infobox.getStyle().set("position","relative");
        infobox.getStyle().set("font-size","3px");
        infobox.setWidth("300px");
        infobox.setHeight("30px");
        infobox.getStyle().set("border", "1px solid black");
        infobox.getStyle().set("background-color", "PaleGoldenRod");
        infobox.getStyle().set("border-radius", "12rem 12rem 0 0");
        infobox.getStyle().set("left","100px");
        infobox.getStyle().set("top","10.5px");




        Div div2 = new Div();
        div2.setWidth("500px");
        div2.setHeight("100px");
        div2.getStyle().set("border", "1px solid black");
        div2.getStyle().set("background-color", "Orange");
        div2.getStyle().set("border-radius", "20px");





        priceGroup = new RadioButtonGroup<>();
        priceGroup.setItems("₺"+String.valueOf(flightController.calculatingprice
                (flightController.getDistance(SelectPortsView.selectarrival.getValue()),
                        Integer.parseInt(SelectPortsView.adultcount.getValue()),
                        Integer.parseInt(SelectPortsView.childcount.getValue()),
                        Integer.parseInt(SelectPortsView.infantcount.getValue()))*5),
                "₺"+ String.valueOf(flightController.calculatingprice
                        (flightController.getDistance(SelectPortsView.selectarrival.getValue()),
                                Integer.parseInt(SelectPortsView.adultcount.getValue()),
                                Integer.parseInt(SelectPortsView.childcount.getValue()),
                                Integer.parseInt(SelectPortsView.infantcount.getValue()))*2));
        priceGroup.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
        priceGroup.getStyle().set("position","relative");
        priceGroup.getStyle().set("margin","10px");
        priceGroup.getStyle().set("width","460px");
        priceGroup.getStyle().set("top","-215px");
        priceGroup.getStyle().set("left","20px");



        priceGroup.getElement().getChild(0).getStyle().set("padding-top","25px");
        priceGroup.getElement().getChild(0).getStyle().set("padding-bottom","80px");
        priceGroup.getElement().getChild(0).getStyle().set("text-decoration","underline");
        priceGroup.getElement().getChild(0).getChild(0).getStyle().set("margin-left","350px");
        priceGroup.getElement().getChild(1).getChild(0).getStyle().set("margin-left","350px");
        priceGroup.getElement().getChild(0).getChild(0).getStyle().set("text-decoration","underline");
        priceGroup.getElement().getChild(1).getChild(0).getStyle().set("text-decoration","underline");
        priceGroup.getElement().getChild(0).getChild(0).getStyle().set("font-size","18px");
        priceGroup.getElement().getChild(1).getChild(0).getStyle().set("font-size","18px");

        Div maindiv = new Div();
        maindiv.add(infobox,firstbox,div2, priceGroup,business,economoy,flightinfo);
        firstbox.getStyle().set("margin-block", "10px");


        Button signup = new Button("Next", buttonClickEvent -> control());
        signup.getStyle().set("top","-300px");
        VerticalLayout layout = new VerticalLayout(maindiv,signup);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);


        VerticalLayout layout2 = new VerticalLayout(layout);


        layout2.setAlignItems(FlexComponent.Alignment.CENTER);
        layout2.getStyle().set("position", "absolute");
        layout2.getStyle().set("left", "100px");




        this.setContent(layout2);


    }


    void control(){
        if(priceGroup.isEmpty()){
            Notification notification = Notification.show("Select a class");
            notification.addThemeVariants(NotificationVariant.LUMO_WARNING);
        }else {

           reservationController.reservation(userController.username,  SelectPortsView.selectdeparture.getValue(),
                   SelectPortsView.selectarrival.getValue() , String.valueOf(SelectPortsView.datePicker.getValue()),
                  Integer.parseInt(SelectPortsView.adultcount.getValue()) , Integer.parseInt(SelectPortsView.childcount.getValue()),
                   Integer.parseInt(SelectPortsView.infantcount.getValue()), SelectPortsView.radioGroup.getValue(),
                  String.valueOf(priceGroup.getValue()) ,generatePNR(5));
           UI.getCurrent().navigate(PassengerinfoView.class);
        }
    }

    public String generatePNR(int length){
        final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String NUMBERS = "0123456789";

            StringBuilder sb = new StringBuilder();
            Random random = new Random();

            for (int i = 0; i < length; i++) {
                if (i % 2 == 0) {

                    int randomIndex = random.nextInt(LETTERS.length());
                    sb.append(LETTERS.charAt(randomIndex));
                } else {

                    int randomIndex = random.nextInt(NUMBERS.length());
                    sb.append(NUMBERS.charAt(randomIndex));
                }
            }

            return sb.toString();
        }

}
