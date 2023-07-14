package com.example.InternshipProject;

import com.example.InternshipProject.Controller.UserController;
import com.example.InternshipProject.Model.User;
import com.example.InternshipProject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class InternshipProjectApplication {

	public static void main(String[] args) {

		 SpringApplication.run(InternshipProjectApplication.class, args);

	}

}