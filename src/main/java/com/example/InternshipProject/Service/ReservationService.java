package com.example.InternshipProject.Service;

import com.example.InternshipProject.Entity.AdultInfo;
import com.example.InternshipProject.Entity.Reservation;
import com.example.InternshipProject.Repository.AdultInfoRepository;
import com.example.InternshipProject.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    AdultInfoRepository adultInfoRepository;
    public void reservation(String rezervistname, String departureport, String arrivalport, String departuredate, int adultcount, int childcount, int infantcount, String flighttype,String price, String pnr){
        reservationRepository.save(new Reservation(rezervistname,  departureport, arrivalport, departuredate, adultcount, childcount, infantcount, flighttype, price,pnr)) ;
    }
    public  void userinforeservation(String pnr, String name, String surname, String birtdate, String gender, int passportno, int nationalityno, String telno, String email){
        adultInfoRepository.save(new AdultInfo(pnr, name, surname, birtdate,  gender, passportno,  nationalityno,  telno,  email));
    }

    public void setStatus(String pnr){
        reservationRepository.setStatus("TICKETED",pnr);
    }

     public void cancelReservation(String username){
         reservationRepository.deleteUserinfo(reservationRepository.findPNR(username));
        reservationRepository.deleteReservation(reservationRepository.findPNR(username));

     }

     public String findPNR(String username){
        return reservationRepository.findPNR(username);
     }

     public String findFlightDatebyPNR(String pnr){
         return reservationRepository.getFlightDatebyPNR(pnr);
     }

     public String  findDepartureandArrivalPortbyPNR(String pnr){
        return reservationRepository.getDeparturePortbyPNR(pnr) + " - " + reservationRepository.getArrivalPortbyPNR(pnr);
     }

     public String getAdultInfobyPNR(String pnr){
        return adultInfoRepository.getNamebyPNR(pnr)+" "+adultInfoRepository.getSurnamebyPNR(pnr)+ "    "+ adultInfoRepository.getBirthdaybyPNR(pnr)+ "       "+ adultInfoRepository.getGenderbyPNR(pnr);
     }

     public String isReserved(String rezervistname){
        return reservationRepository.isReserved(rezervistname);
     }

     public String getPnr(String pnr){
        return reservationRepository.getPnr(pnr);
     }
}
