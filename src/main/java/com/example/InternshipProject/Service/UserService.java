package com.example.InternshipProject.Service;

import com.example.InternshipProject.Model.User;
import com.example.InternshipProject.Repository.UserRepository;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

    public void registerUser(User user){

         if(userRepository.existsById(user.getUsername())){

            Notification notification = Notification
                    .show("The User Already Exist");
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        }else{
            Notification notification = Notification
                    .show("Account has been generated succesfully");
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            userRepository.save(user);
        }


    }
}

