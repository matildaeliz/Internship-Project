package com.example.InternshipProject.Repository;

import com.example.InternshipProject.Entity.Reservation;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import static org.hibernate.sql.ast.Clause.*;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,String> {
    @Modifying
    @Transactional
    @Query("UPDATE Reservation SET Status =:Status WHERE pnr =:pnr")
    void setStatus( @Param("Status")String Status,@Param("pnr") String pnr);


    @Query("SELECT DISTINCT reservation.pnr FROM User  user JOIN Reservation reservation ON user.username=:username AND reservation.rezervistname =:username")
    String findPNR(@Param("username")String username);
    @Transactional
    @Modifying
    @Query("DELETE FROM Reservation reservation WHERE reservation.pnr =:pnr ")
    void deleteReservation(@Param("pnr") String pnr);

    @Transactional
    @Modifying
    @Query("DELETE FROM AdultInfo adultinfo WHERE  adultinfo.pnr=:pnr")
    void deleteUserinfo(@Param("pnr") String pnr);

    @Query("SELECT reservation.departuredate FROM Reservation reservation WHERE reservation.pnr =:pnr")
    String getFlightDatebyPNR(@Param("pnr")String pnr);
    @Query("SELECT reservation.departureport FROM Reservation reservation WHERE  reservation.pnr=:pnr")
    String getDeparturePortbyPNR(@Param("pnr") String pnr);
    @Query("SELECT reservation.arrivalport FROM Reservation reservation WHERE  reservation.pnr=:pnr")
    String getArrivalPortbyPNR(@Param("pnr") String pnr);

    @Query("SELECT reservation.rezervistname FROM Reservation reservation WHERE reservation.rezervistname=:rezervistname")
    String isReserved(@Param("rezervistname") String rezervistname);
    @Query("SELECT reservation.pnr FROM Reservation reservation WHERE reservation.pnr=:pnr")
    String getPnr(@Param("pnr") String pnr);


}
