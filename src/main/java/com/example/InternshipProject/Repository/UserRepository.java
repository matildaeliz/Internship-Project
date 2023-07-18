package com.example.InternshipProject.Repository;

import com.example.InternshipProject.Entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,String> {

    @Query("SELECT user.password FROM User user WHERE user.username =:username")
     String authorization(@Param("username") String username);
@Transactional
@Modifying
  @Query("DELETE FROM User user WHERE user.username =:username")
    void deleteUser(@Param("username") String username);

}
