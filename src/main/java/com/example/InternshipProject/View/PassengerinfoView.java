package com.example.InternshipProject.View;

import com.example.InternshipProject.Controller.ReservationController;
import com.example.InternshipProject.Controller.UserController;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Passenger Info")
@Route("/passengerinfo")
public class PassengerinfoView extends MainLayoutView implements ViewInterface{

    public static TextField name,surname,passportno,nationalityno,telno,email;


    public static DatePicker datePicker;
    public static Select<String>  gender;

    public  PassengerinfoView(UserController userController,ReservationController reservationController){
    super(userController,reservationController);
    VerticalLayout layout = new VerticalLayout();

    H1 adultinfo = new H1("ADULT INFO");

    name = new TextField("Name");
    name.getStyle().set("padding","2px");
    surname = new TextField("Surname");
    surname.getStyle().set("padding","2px");
    datePicker = new DatePicker("Birthday");
    datePicker.getStyle().set("padding","2px");
    gender = new Select<>();
    gender.getStyle().set("padding","2px");
    gender.setLabel("Gender");
    gender.setItems("Male","Female");
    passportno= new TextField("Passport No");
    passportno.getStyle().set("padding","2px");
    nationalityno = new TextField("Nationality No");
    nationalityno.getStyle().set("padding","2px");
    telno = new TextField("Tell No");
    telno.getStyle().set("padding","2px");
    email = new TextField("Email");


    Button next = new Button("Continue", event ->control());

    Div maindiv = new Div();


    maindiv.add(adultinfo,name,surname,datePicker,gender,passportno,nationalityno,telno,email);





    layout.add(maindiv,next);
    this.setContent(layout);


}
   public void control(){
        try {
            if(name.isEmpty() || datePicker.isEmpty()|| surname.isEmpty() || gender.isEmpty() || passportno .isEmpty()|| nationalityno.isEmpty() || telno.isEmpty() || email.isEmpty()){
                Notification notification = Notification.show("All fields must be filled");
                notification.addThemeVariants(NotificationVariant.LUMO_WARNING);
            }else {

                reservationController.adultinforeservation(AvailableFlightView.PNR,name.getValue(), surname.getValue(), java.lang.String.valueOf(datePicker.getValue()),
                        gender.getValue(),Integer.parseInt(passportno.getValue()),Integer.parseInt(nationalityno.getValue()),telno.getValue(),email.getValue());
                UI.getCurrent().navigate(PaymentView.class);
            }
        }catch (NumberFormatException e){
            Notification notification = Notification.show("Enter valid characters");
            notification.addThemeVariants(NotificationVariant.LUMO_WARNING);
        }

    }
}
