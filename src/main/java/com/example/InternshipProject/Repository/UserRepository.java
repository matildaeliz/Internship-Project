package com.example.InternshipProject.Repository;

import com.example.InternshipProject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,String> {

    @Query("SELECT user.password FROM User user WHERE user.username =:username")
     String authorization(@Param("username") String username);

}
