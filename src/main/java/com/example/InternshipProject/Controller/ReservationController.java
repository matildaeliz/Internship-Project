package com.example.InternshipProject.Controller;

import com.example.InternshipProject.Repository.ReservationRepository;
import com.example.InternshipProject.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class ReservationController {
    @Autowired
  ReservationService reservationService;

    public void reservation(String rezervistname, String departureport, String arrivalport, String departuredate, int adultcount, int childcount, int infantcount, String flighttype,String price, String pnr){
        reservationService.reservation(rezervistname,  departureport, arrivalport, departuredate, adultcount, childcount, infantcount, flighttype, price,pnr);
    }
}
