package com.example.InternshipProject;

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

@Route(value = "/login")
@PageTitle("Login")
class LoginView extends AppLayout {

    public LoginView() {
        VerticalLayout textlayout = new VerticalLayout();
        HorizontalLayout buttonlayout = new HorizontalLayout();
        Image icon = new Image("META-INF/resources/images/icon.png","ICON");

        TextField username = new TextField("Username");
        PasswordField password = new PasswordField(("Password"));
        Button login = new Button("Login");
        Button signup = new Button("Sign up");


        buttonlayout.add(login,signup);
        textlayout.setHorizontalComponentAlignment(FlexComponent.Alignment.CENTER,icon, username, password,buttonlayout);
        textlayout.add(icon,username, password,buttonlayout);
        this.setContent(textlayout);


        signup.addClickListener(buttonClickEvent -> UI.getCurrent().navigate(SignUp.class));
    }

}
@Route(value = "/signup")
@PageTitle("Sign up")
class SignUp extends  AppLayout{
   public SignUp(){
       VerticalLayout textlayout = new VerticalLayout();
       HorizontalLayout buttonlayout = new HorizontalLayout();

       TextField username = new TextField("Username");
       PasswordField password = new PasswordField(("Password"));
       Button signup = new Button("Sign up");
       Button back = new Button("Back");
       buttonlayout.add(signup,back);
       textlayout.setHorizontalComponentAlignment(FlexComponent.Alignment.CENTER, back,username, password,buttonlayout);
       textlayout.add(username, password,buttonlayout);
       this.setContent(textlayout);

      back.addClickListener(buttonClickEvent -> UI.getCurrent().navigate(LoginView.class));



}
    }