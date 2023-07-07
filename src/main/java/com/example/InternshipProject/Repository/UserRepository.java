package com.example.InternshipProject.Repository;

import com.example.InternshipProject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

}
