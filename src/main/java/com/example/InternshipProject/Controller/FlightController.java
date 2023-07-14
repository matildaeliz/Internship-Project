package com.example.InternshipProject.Controller;

import com.example.InternshipProject.Service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class FlightController {

    @Autowired
    FlightService flightService;
    public String findAircraft(String arrivalport){
        return flightService.findAircraft(arrivalport);
    }
}
