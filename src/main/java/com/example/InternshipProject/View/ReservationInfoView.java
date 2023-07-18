package com.example.InternshipProject.View;


import com.example.InternshipProject.Controller.FlightController;
import com.example.InternshipProject.Controller.ReservationController;
import com.example.InternshipProject.Controller.UserController;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@PageTitle("Reservation Info")
@Route("/reservationinfo")
public class ReservationInfoView extends MainLayoutView{

    @Autowired
   protected FlightController flightController;

    public ReservationInfoView(ReservationController reservationController, UserController userController,FlightController flightController){
        super(userController,reservationController);

        this.flightController = flightController;


        VerticalLayout layout = new VerticalLayout();
        Div maindiv =new Div();
        H1 PNR = new H1("PNR NUMBER: "+ reservationController.findPNR(userController.username));
        PNR.getStyle().set("position","relative")
        .set("font-size","12px")
        .set("left","500px");

        H1 flightinfos =new H1(" "+ flightController.findAircraftByPnr(reservationController.findPNR(userController.username))+" "
        + reservationController.findFlightDatebyPNR(reservationController.findPNR(userController.username)) + " "+
                reservationController.findDepartureandArrivalPortbyPNR(reservationController.findPNR(userController.username)));
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



        H1 passengerinfos = new H1(reservationController.getAdultInfo(reservationController.findPNR(userController.username)));
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

        Button OK = new Button("Cancel Reservation");
        OK.getStyle().set("position","relative");
        OK.getStyle().set("left","500px");
        OK.addThemeVariants(ButtonVariant.LUMO_PRIMARY,
                ButtonVariant.LUMO_SUCCESS);
        OK.getStyle().set("border-radius", "0 12rem 12rem 12rem");
        OK.getStyle().set("border","2px solid black");
        OK.addClickListener(buttonClickEvent -> cancelreservation());
        maindiv.add(PNR,flightinfo,passengerinfo);

        if(PnrSearchView.pnrfield == null){
            maindiv.add(OK);
        }
       else if (reservationController.findPNR(userController.username) != PnrSearchView.pnrfield.getValue()){
            passengerinfos.setText(reservationController.getAdultInfo(PnrSearchView.pnrfield.getValue()));
            flightinfo.setText(flightController.findAircraftByPnr(PnrSearchView.pnrfield.getValue())+" "
                    + reservationController.findFlightDatebyPNR(PnrSearchView.pnrfield.getValue()) + " "+
                    reservationController.findDepartureandArrivalPortbyPNR(PnrSearchView.pnrfield.getValue()));
        }
         layout.add(maindiv);

         this.setContent(layout);



    }

    public void cancelreservation(){
        reservationController.cancelReservation(userController.username);

        UI.getCurrent().navigate(SelectPortsView.class);
    }
}
