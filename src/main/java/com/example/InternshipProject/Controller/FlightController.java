package com.example.InternshipProject.Controller;

import com.example.InternshipProject.Service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
@Controller
public class FlightController {
    @Autowired
    FlightService flightService ;


    public int getDistance(String arrivalport){
        return flightService.getDistance(arrivalport);
    }

    public int calculatingprice(int distance, int adult,int child,int infant){
      return  flightService.calculatingprice(distance,adult,child,infant);
    }

    public String findAircraft(String arrivalport){
       return flightService.findAircraft(arrivalport);
    }
}
