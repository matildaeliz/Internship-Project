package com.example.InternshipProject.Service;

import com.example.InternshipProject.Repository.FlightRepository;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.awt.desktop.PreferencesEvent;

@Service
public class FlightService {
    @Autowired
    FlightRepository flightRepository;

public int getDistance(String arrivalport){
    return flightRepository.getDistance(arrivalport);
}
    public String findAircraft(String arrivalport){
        return flightRepository.findAircraft(arrivalport);
    }

    public int calculatingprice(int distance, int adult, int child, int infant){
        int price = 0;

        int totalPassengers = adult + child + infant;
        price += totalPassengers * distance;

        price -= child * distance * 0.3;
        price -= infant * distance * 0.6;

        return price;
    }
}
