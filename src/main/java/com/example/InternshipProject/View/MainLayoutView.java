package com.example.InternshipProject.View;

import com.example.InternshipProject.Controller.ReservationController;
import com.example.InternshipProject.Controller.UserController;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import org.hibernate.validator.constraints.CodePointLength;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class MainLayoutView extends AppLayout {
    @Autowired
    ReservationController reservationController;
    @Autowired
    UserController userController;
    protected    RouterLink reservation;
    protected    RouterLink pnrsearch ;
    protected    RouterLink usermanagement ;
    public MainLayoutView(UserController userController,ReservationController reservationController) {
        this.userController = userController;
        this.reservationController = reservationController;
        H1 appTitle = new H1("MENU");
        appTitle.getStyle().set("font-size", "var(--lumo-font-size-l)")
                .set("line-height", "var(--lumo-size-l)")
                .set("margin", "0 var(--lumo-space-m)");


        HorizontalLayout wrapper = new HorizontalLayout();
        wrapper.setAlignItems(FlexComponent.Alignment.CENTER);
        wrapper.setSpacing(false);

        VerticalLayout viewHeader = new VerticalLayout(wrapper);
        viewHeader.setPadding(false);
        viewHeader.setSpacing(false);

        addToDrawer(appTitle);
        VerticalLayout layout = new VerticalLayout();
        reservation = new RouterLink("Reservation", SelectPortsView.class);
        pnrsearch = new RouterLink("PNR Search", PnrSearchView.class);
        usermanagement = new RouterLink("User Management", UserManagementView.class);


        if(reservationController.isReserved(userController.username) !=null){
            reservation.getElement().removeAttribute("href");
        }
        Button exit = new Button("Exit", buttonClickEvent -> UI.getCurrent().navigate(LoginView.class));
        layout.add(reservation);
        layout.add(pnrsearch);
        layout.add(usermanagement);
        layout.add(exit);
        layout.getStyle().set("display","sticky");
        addToDrawer(layout);
        addToNavbar(viewHeader);
        setPrimarySection(Section.DRAWER);


    }

}
