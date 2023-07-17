package com.example.InternshipProject.View;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import org.hibernate.validator.constraints.CodePointLength;
import org.springframework.stereotype.Component;


public class MainLayoutView extends AppLayout {

    public MainLayoutView() {
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
        layout.add(new RouterLink("Reservation", SelectPortsView.class));
        layout.add(new RouterLink("PNR Search", PnrSearchView.class));
        layout.add(new RouterLink("User Management", UserManagementView.class));
        layout.getStyle().set("display","sticky");
        addToDrawer(layout);
        addToNavbar(viewHeader);
        setPrimarySection(Section.DRAWER);


    }

}
