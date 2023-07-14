package com.example.InternshipProject.Controller;

import com.example.InternshipProject.Model.User;
import com.example.InternshipProject.Service.FlightService;
import com.example.InternshipProject.Service.UserService;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.time.LocalDate;

@Controller
public class UserController {
@Autowired
   UserService Userservice;

String username;


public  void registerUser(String username, String password){
if(username.isBlank() || password.isBlank()){

    Notification notification = Notification.show("Username or Password cannot be empty");
notification.addThemeVariants(NotificationVariant.LUMO_WARNING);

}else
    Userservice.registerUser(new User(username,password));
}

public void authorization(String username, String password){
    if(username.isBlank() || password.isBlank()){
        Notification notification = Notification.show("Username or Password cannot be empty");
        notification.addThemeVariants(NotificationVariant.LUMO_WARNING);
    }else {
       this.username = username;
        Userservice.authorization(username,password);

 }
}

public void rezervation(String radio , String departure, String arrival, LocalDate date, int adult, int child, int infant ){
      Userservice.reservation(this.username,radio,departure, arrival, String.valueOf(date),adult, child, infant);
}



}
