package com.example.InternshipProject.Model;

import com.example.InternshipProject.Repository.FlightRepository;
import com.example.InternshipProject.Repository.ReservationRepository;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="flightinfo")

public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private  String departureport;
    @Column
    private String arrivalport;
    @Column
    private int distance;

    @Column
    private String aircraft;

    public Flight(){




        }
    }

