package com.example.InternshipProject.View;

import com.example.InternshipProject.Controller.UserController;
import com.example.InternshipProject.Entity.User;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Route(value = "/signup")

@PageTitle("Sign up")
public class SignUpView extends AppLayout  {
    @Autowired
    UserController userController;

    TextField usernametext;
    TextField passwordtext;
    public SignUpView() {

        VerticalLayout textlayout = new VerticalLayout();
        HorizontalLayout buttonlayout = new HorizontalLayout();

        TextField usernametext = new TextField("Username");
        TextField passwordtext = new TextField(("Password"));
        Button signup = new Button("Sign up", event -> control(usernametext,passwordtext));
        Button back = new Button("Back");
        buttonlayout.add(signup, back);
        textlayout.setHorizontalComponentAlignment(FlexComponent.Alignment.CENTER, back, usernametext, passwordtext, buttonlayout);
        textlayout.add(usernametext, passwordtext, buttonlayout);
        this.setContent(textlayout);

        back.addClickListener(buttonClickEvent -> UI.getCurrent().navigate(LoginView.class));

    }



    public void control(TextField usernametext, TextField passwordtext) {
        if(usernametext.getValue().isEmpty()|| passwordtext.getValue().isEmpty()){

            Notification notification = Notification.show("Username or Password cannot be empty");
            notification.addThemeVariants(NotificationVariant.LUMO_WARNING);

        }else
            userController.registerUser(usernametext.getValue(),passwordtext.getValue());
    }

}
