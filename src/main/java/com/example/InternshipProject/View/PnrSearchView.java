package com.example.InternshipProject.View;

import com.example.InternshipProject.Controller.FlightController;
import com.example.InternshipProject.Controller.ReservationController;
import com.example.InternshipProject.Controller.UserController;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.ParentLayout;
import com.vaadin.flow.router.Route;
import org.atmosphere.interceptor.AtmosphereResourceStateRecovery;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("PNR Search | PNRS")
@ParentLayout(MainLayoutView.class)
@Route("/pnrsearch")
public class PnrSearchView extends MainLayoutView implements ViewInterface {
   public static TextField pnrfield;
    public PnrSearchView(UserController userController, ReservationController reservationController){
        super(userController,reservationController);

        Div div = new Div();

        pnrfield = new TextField("PNR Number");
        Button pnrSearch = new Button("PNR SEARCH",buttonClickEvent ->control());

          div.getStyle().set("position","relative")
                  .set("right", "-600px")
                  .set("bottom", "-300px");
          div.add(pnrfield,pnrSearch);




        this.setContent(new VerticalLayout(div));

    }

    @Override
    public void control() {
        if(reservationController.getPNR(pnrfield.getValue()) == null){
            Notification notification = Notification.show("Wrong Username or Password");
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        }else {
            UI.getCurrent().navigate(ReservationInfoView.class);
        }
    }
}
