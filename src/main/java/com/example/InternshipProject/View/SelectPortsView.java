package com.example.InternshipProject.View;

import com.example.InternshipProject.Controller.UserController;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Reservation | RMS")
@Route(value = "/selectports")
public class SelectPortsView extends MainLayoutView {
    @Autowired
    public UserController UserController ;

   public static  RadioButtonGroup<String> radioGroup ;
    public static DatePicker datePicker;
    public static Select<String>  adultcount,childcount,infantcount,selectdeparture,selectarrival;


    public SelectPortsView(){
      super();
      HorizontalLayout horizontalLayout=new HorizontalLayout();
      VerticalLayout layout = new VerticalLayout();
      radioGroup = new RadioButtonGroup<>();
      radioGroup.setLabel("Type of Flight");
      radioGroup.setItems("One Way", "Round Trip");
      layout.setAlignItems(FlexComponent.Alignment.CENTER);
      radioGroup.setRequired(true);
      layout.add(radioGroup);


      selectdeparture = new Select<>();
      selectarrival = new Select<>();
      selectdeparture.setLabel("Departure Port");
      selectdeparture.setItems("IST");
      selectdeparture.setPlaceholder("Select Departure Port");
      selectarrival.setLabel("Arrival Port");
      selectarrival.setItems("WAS", "BAK", "DHM", "PAR","ESS"," ROM");
      selectarrival.setPlaceholder("Select Arrival Port");
      selectdeparture.setRequiredIndicatorVisible(true);
      selectarrival.setRequiredIndicatorVisible(true);

       datePicker = new DatePicker("Departure date");
      datePicker.setRequired(true);
      datePicker.setRequiredIndicatorVisible(true);



      adultcount = new Select<>();
      childcount = new Select<>();
      infantcount = new Select<>();
      adultcount.setLabel("Adult Count");
      adultcount.setItems("0","1","2","3","4","5");
      childcount.setLabel("Child Count");
      childcount.setItems("0","1","2","3","4","5");
      infantcount.setLabel("Infant Count");
      infantcount.setItems("0","1","2","3","4","5");
      adultcount.setRequiredIndicatorVisible(true);
      childcount.setRequiredIndicatorVisible(true);
      infantcount.setRequiredIndicatorVisible(true);
      HorizontalLayout countlayout = new HorizontalLayout(adultcount,childcount,infantcount);
      Button search = new Button("Search");
      search.addClickListener(buttonClickEvent -> control());

      horizontalLayout.add(selectdeparture,selectarrival);
      layout.add(horizontalLayout,datePicker,countlayout, new HorizontalLayout(search));
      this.setContent(layout);

  }

  void control(){
      if(radioGroup.isEmpty() || datePicker.isEmpty()|| selectarrival.isEmpty() || selectdeparture.isEmpty() || adultcount .isEmpty()|| childcount.isEmpty() || infantcount.isEmpty()){
          Notification notification = Notification.show("All fields must be filled");
          notification.addThemeVariants(NotificationVariant.LUMO_WARNING);
      }else {
          UI.getCurrent().navigate(AvailableFlightView.class);
      }
  }
}
