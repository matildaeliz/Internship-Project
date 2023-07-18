package com.example.InternshipProject.Controller;

import com.example.InternshipProject.Repository.ReservationRepository;
import com.example.InternshipProject.Service.ReservationService;
import org.apache.http.conn.util.PublicSuffixList;
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

    public void adultinforeservation(String pnr, String name, String surname, String birtdate, String gender, int passportno, int nationalityno, String telno, String email){
        reservationService.userinforeservation(pnr, name, surname, birtdate,  gender, passportno,  nationalityno,  telno,  email);
    }
    public void setStatus(String pnr){
        reservationService.setStatus(pnr);
    }

    public void cancelReservation(String username){
        reservationService.cancelReservation(username);
    }

    public String findPNR(String username){
     return reservationService.findPNR(username);
    }
    public String findFlightDatebyPNR(String pnr){
        return reservationService.findFlightDatebyPNR(pnr);
    }

    public String  findDepartureandArrivalPortbyPNR(String pnr){
        return reservationService.findDepartureandArrivalPortbyPNR(pnr);
    }

    public String getAdultInfo(String pnr){
        return reservationService.getAdultInfobyPNR(pnr);
    }
   public String isReserved(String rezervistname){
        return reservationService.isReserved(rezervistname);
   }

   public String getPNR(String pnr){
        return reservationService.getPnr(pnr);
   }
}
