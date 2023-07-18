package com.example.InternshipProject.Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "AdultInfo")
public class AdultInfo {

    @Id
@Column

private String pnr;
    @Column
    private   String name;
    @Column
    private String surname;
    @Column
    private String birtdate;
    @Column
    private String gender;
    @Column
    private int passportno;
    @Column
    private int nationalityno;
    @Column
    private String  telno;
    @Column
    private String email;

    public AdultInfo(String pnr, String name, String surname, String birtdate, String gender, int passportno, int nationalityno, String telno, String email) {
        this.pnr = pnr;
        this.name = name;
        this.surname = surname;
        this.birtdate = birtdate;
        this.gender = gender;
        this.passportno = passportno;
        this.nationalityno = nationalityno;
        this.telno = telno;
        this.email = email;
    }

    public AdultInfo() {

    }

    public String getPnr() {
        return pnr;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirtdate() {
        return birtdate;
    }

    public String getGender() {
        return gender;
    }

    public int getPassportno() {
        return passportno;
    }

    public int getNationalityno() {
        return nationalityno;
    }

    public String getTelno() {
        return telno;
    }

    public String getEmail() {
        return email;
    }
}
