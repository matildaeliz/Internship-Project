package com.example.InternshipProject.Repository;

import com.example.InternshipProject.Entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

     @Repository
public interface FlightRepository extends JpaRepository<Flight, String> {
          @Query("SELECT flight.aircraft FROM Flight flight WHERE flight.arrivalport =:arrivalport")
           String findAircraft(@Param("arrivalport") String arrivalport);
          @Query("SELECT flight.distance FROM Flight flight WHERE flight.arrivalport=:arrivalport")
          int getDistance(@Param("arrivalport") String arrivalport);


         @Query("SELECT flight.aircraft  FROM Reservation reservation JOIN Flight flight ON  flight.arrivalport = reservation.arrivalport where  reservation.pnr=:pnr")
         String findAircraftByPNR(@Param("pnr") String pnr);
}
