package com.example.InternshipProject.View;

import com.example.InternshipProject.Controller.UserController;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@Route(value = "/signup")
@PageTitle("Sign up")

public class SignUp extends AppLayout {
@Autowired
    UserController controller;

    public SignUp() {

        VerticalLayout textlayout = new VerticalLayout();
        HorizontalLayout buttonlayout = new HorizontalLayout();

        TextField usernametext = new TextField("Username");
        TextField passwordtext = new TextField(("Password"));
        Button signup = new Button("Sign up", event -> controller.registerUser(usernametext.getValue(),passwordtext.getValue()));
        Button back = new Button("Back");
        buttonlayout.add(signup, back);
        textlayout.setHorizontalComponentAlignment(FlexComponent.Alignment.CENTER, back, usernametext, passwordtext, buttonlayout);
        textlayout.add(usernametext, passwordtext, buttonlayout);
        this.setContent(textlayout);

        back.addClickListener(buttonClickEvent -> UI.getCurrent().navigate(com.example.InternshipProject.View.LoginView.class));

    }


}
