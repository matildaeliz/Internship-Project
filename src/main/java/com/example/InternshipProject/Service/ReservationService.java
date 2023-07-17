package com.example.InternshipProject.Service;

import com.example.InternshipProject.Entity.Reservation;
import com.example.InternshipProject.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    ReservationRepository reservationRepository;
    public void reservation(String rezervistname, String departureport, String arrivalport, String departuredate, int adultcount, int childcount, int infantcount, String flighttype,String price, String pnr){
        reservationRepository.save(new Reservation(rezervistname,  departureport, arrivalport, departuredate, adultcount, childcount, infantcount, flighttype, price,pnr)) ;
    }
}
