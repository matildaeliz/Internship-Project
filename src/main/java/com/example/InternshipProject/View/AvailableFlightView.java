package com.example.InternshipProject.View;

import com.example.InternshipProject.Controller.FlightController;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Available Flight")
@Route("/availableflight")
public class AvailableFlightView extends  MainLayoutView{
@Autowired
FlightController flightController ;
  public static  RadioButtonGroup<String> radioGroup;
    public AvailableFlightView(){
        super();
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

        H1 flightinfo = new H1(flightController.findAircraft(SelectPortsView.selectarrival.getValue())+" "
                + SelectPortsView.selectdeparture.getValue()+"-"+SelectPortsView.selectarrival.getValue()
                + " "+SelectPortsView.datePicker.getValue());

        flightinfo.getStyle().set("top","-505px");
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





        radioGroup = new RadioButtonGroup<>();
        radioGroup.setItems("Seçenek 1", "Seçenek 2");
        radioGroup.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
        radioGroup.getStyle().set("position","relative");
        radioGroup.getStyle().set("margin","10px");
        radioGroup.getStyle().set("width","460px");
        radioGroup.getStyle().set("top","-215px");
        radioGroup.getStyle().set("left","20px");



        radioGroup.getElement().getChild(0).getStyle().set("padding-top","25px");
        radioGroup.getElement().getChild(0).getStyle().set("padding-bottom","80px");
        radioGroup.getElement().getChild(0).getStyle().set("text-decoration","underline");
        radioGroup.getElement().getChild(0).getChild(0).getStyle().set("margin-left","350px");
        radioGroup.getElement().getChild(1).getChild(0).getStyle().set("margin-left","350px");
        radioGroup.getElement().getChild(0).getChild(0).getStyle().set("text-decoration","underline");
        radioGroup.getElement().getChild(1).getChild(0).getStyle().set("text-decoration","underline");


        Div maindiv = new Div();
        maindiv.add(infobox,firstbox,div2,radioGroup,business,economoy,flightinfo);
        firstbox.getStyle().set("margin-block", "10px");



        VerticalLayout layout = new VerticalLayout(maindiv);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        VerticalLayout layout2 = new VerticalLayout(layout);


        layout2.setAlignItems(FlexComponent.Alignment.CENTER);
        layout2.getStyle().set("position", "absolute");
        layout2.getStyle().set("left", "100px");

        this.setContent(layout2);


    }
}
