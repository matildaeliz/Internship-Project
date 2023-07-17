package com.example.InternshipProject.Entity;

import jakarta.persistence.*;

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

