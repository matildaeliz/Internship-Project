package com.example.InternshipProject.Repository;

import com.example.InternshipProject.Model.Flight;
import com.example.InternshipProject.View.SelectPortsView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, String> {
          @Query("SELECT flight.aircraft FROM Flight flight WHERE flight.arrivalport =:arrivalport")
           String findAircraft(@Param("arrivalport") String arrivalport);


}
