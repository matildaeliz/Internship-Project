package com.example.InternshipProject.Controller;

import com.example.InternshipProject.Entity.User;
import com.example.InternshipProject.Service.UserService;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
@Autowired
   UserService Userservice;

    public String username;


public void registerUser(String username, String password){
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
public void deleteUser(String username){

        Userservice.deleteUser(username);


}

}
