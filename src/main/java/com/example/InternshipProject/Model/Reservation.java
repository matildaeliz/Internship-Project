package com.example.InternshipProject.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "reservationinfo")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int reservationid;
    @Column
    private String rezervistname;
    @Column
    private String departureport;
    @Column
    private String arrivalport;
    @Column
    private String departuredate;
    @Column
    private int adultcount;
    @Column
    private int childcount;
    @Column
    private int infantcount;
    @Column
    private String flighttype;

    public Reservation(String rezervistname, String departureport, String arrivalport, String departuredate, int adultcount, int childcount, int infantcount, String flighttype) {

        this.rezervistname = rezervistname;
        this.departureport = departureport;
        this.arrivalport = arrivalport;
        this.departuredate = departuredate;
        this.adultcount = adultcount;
        this.childcount = childcount;
        this.infantcount = infantcount;
        this.flighttype = flighttype;
    }

    public Reservation(){}


}
