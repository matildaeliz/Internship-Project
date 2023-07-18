package com.example.InternshipProject.Repository;

import com.example.InternshipProject.Entity.AdultInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdultInfoRepository extends JpaRepository<AdultInfo,String> {


    @Query("SELECT adultinfo.name FROM  AdultInfo adultinfo WHERE adultinfo.pnr=:pnr")
    String getNamebyPNR(@Param("pnr") String pnr);
    @Query("SELECT adultinfo.surname  FROM  AdultInfo adultinfo WHERE adultinfo.pnr=:pnr")
    String getSurnamebyPNR(@Param("pnr") String pnr);
    @Query("SELECT adultinfo.birtdate FROM  AdultInfo adultinfo WHERE adultinfo.pnr=:pnr")
    String getBirthdaybyPNR(@Param("pnr") String pnr);
    @Query("SELECT adultinfo.gender FROM  AdultInfo adultinfo WHERE adultinfo.pnr=:pnr")
    String getGenderbyPNR(@Param("pnr") String pnr);
}
