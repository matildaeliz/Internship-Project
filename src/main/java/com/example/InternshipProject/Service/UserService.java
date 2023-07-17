package com.example.InternshipProject.Service;

import com.example.InternshipProject.Entity.User;
import com.example.InternshipProject.Repository.ReservationRepository;
import com.example.InternshipProject.Repository.UserRepository;
import com.example.InternshipProject.View.SelectPortsView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service

public class UserService {
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public ReservationRepository reservationRepository;

    public void registerUser(User user) {

        if (userRepository.existsById(user.getUsername())) {

            Notification notification = Notification
                    .show("The User Already Exist");
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        } else {
            Notification notification = Notification
                    .show("Account has been generated succesfully");
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            userRepository.save(user);
        }
    }


    public void authorization(String username, String password){
       if(userRepository.authorization(username) == null || !userRepository.authorization(username).equals(password)){
           Notification notification = Notification.show("Wrong Username or Password");
           notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
       }else{
           UI.getCurrent().navigate(SelectPortsView.class);
       }
    }






}
