package com.example.InternshipProject.Service;

import com.example.InternshipProject.Repository.FlightRepository;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class FlightService {
    @Autowired
    FlightRepository flightRepository;


    public String findAircraft(String arrivalport){
        return flightRepository.findAircraft(arrivalport);
    }
}
