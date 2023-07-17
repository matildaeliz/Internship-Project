package com.example.InternshipProject.View;

import com.example.InternshipProject.Controller.UserController;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;

import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Route(value = "")
    @PageTitle("Login")

    public class LoginView extends AppLayout {

        @Autowired
        public  UserController UserController ;


        public LoginView() {
            VerticalLayout textlayout = new VerticalLayout();
            HorizontalLayout buttonlayout = new HorizontalLayout();
            Image icon = new Image("META-INF/resources/images/icon.png", "ICON");

            TextField username = new TextField("Username");
            PasswordField password = new PasswordField(("Password"));
            Button login = new Button("Login" , event -> UserController.authorization(username.getValue(),password.getValue()));
            Button signup = new Button("Sign up");


            buttonlayout.add(login, signup);
            textlayout.setHorizontalComponentAlignment(FlexComponent.Alignment.CENTER, icon, username, password, buttonlayout);
            textlayout.add(icon, username, password, buttonlayout);
            this.setContent(textlayout);



            signup.addClickListener(buttonClickEvent -> UI.getCurrent().navigate(SignUpView.class));
        }
    }



