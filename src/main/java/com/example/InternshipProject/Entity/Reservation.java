package com.example.InternshipProject.Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "reservationinfo")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int reservationid;
    @Column
    private String pnr;
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
    @Column
    private String price;
    @Column
    private String Status = "UNTICKETED";
    public Reservation(String rezervistname, String departureport, String arrivalport, String departuredate, int adultcount, int childcount, int infantcount, String flighttype,String price, String pnr) {

        this.rezervistname = rezervistname;
        this.departureport = departureport;
        this.arrivalport = arrivalport;
        this.departuredate = departuredate;
        this.adultcount = adultcount;
        this.childcount = childcount;
        this.infantcount = infantcount;
        this.flighttype = flighttype;
        this.price = price;
        this.pnr = pnr;
    }

    public Reservation(){}


}
