package com.AppNowFinal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.AppNowFinal.auth.UserRepository;

@SpringBootApplication
public class ApprenticeNowFinalApplication {

	@Autowired
	UserRepository userRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(ApprenticeNowFinalApplication.class, args);
	}

}