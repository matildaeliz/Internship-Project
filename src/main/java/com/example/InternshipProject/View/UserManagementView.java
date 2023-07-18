package com.example.InternshipProject.View;

import com.example.InternshipProject.Controller.ReservationController;
import com.example.InternshipProject.Controller.UserController;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("User Management | UMS")
@Route("/usermanagement")
public class UserManagementView extends MainLayoutView {
    TextField username;
    TextField password;
    TextField passwordagain;
    TextField deleteusername;
    public UserManagementView(UserController userController, ReservationController reservationController){
        super(userController,reservationController);
         VerticalLayout layout = new VerticalLayout();


        TextField username = new TextField("Username :");
        TextField password = new TextField("Password :");
        TextField passwordagain = new TextField("Password (Again) :");
        TextField deleteusername = new TextField("Username :");

        Button adduserbutton = new Button("ADD USER",event -> controlAdduser(username,password,passwordagain));
        adduserbutton.getStyle().set("position","relative").set("right","-85px");


        Button deleteUserbutton = new Button("DELETE USER", event ->controlDeleteuser(deleteusername));
        deleteUserbutton.getStyle().set("position","relative").set("right","-65px");
        layout.getStyle().set("position","relative")
                .set("right", "-600px")
                .set("bottom", "-100px");
       layout.add(username,password,passwordagain,adduserbutton,deleteusername,deleteUserbutton);



        this.setContent(layout);
    }


    public void controlAdduser( TextField username,TextField password,TextField passwordagain) {
        if(username.getValue().isBlank()|| password.getValue().isBlank() || passwordagain.getValue().isBlank()){
            Notification notification = Notification.show("Username and Password cannot be empty");
            notification.addThemeVariants(NotificationVariant.LUMO_WARNING);
        }else if(String.valueOf(password.getValue()) != String.valueOf(password.getValue())){
            Notification notification = Notification.show("Passwords must be same!");
            notification.addThemeVariants(NotificationVariant.LUMO_WARNING);
        }else{
            userController.registerUser(username.getValue(),password.getValue());
        }
    }

    public void controlDeleteuser(TextField deleteusername){
        if(deleteusername.getValue().isBlank()){
            Notification notification = Notification.show("Username cannot be empty");
            notification.addThemeVariants(NotificationVariant.LUMO_WARNING);
        }else{
            Notification notification = Notification.show("User is deleted successfully");
            notification.addThemeVariants(NotificationVariant.LUMO_WARNING);
            userController.deleteUser(deleteusername.getValue());
        }
    }

}
