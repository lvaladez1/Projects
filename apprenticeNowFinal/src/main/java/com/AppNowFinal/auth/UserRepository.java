package com.AppNowFinal.auth;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AppNowFinal.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
	User findByUserID(Long userID);
	User findByFirstName(String firstName);
	User findByLastName(String lastName);
	
	List<User> findByEmailContainingIgnoreCase(String email);
	List<User> findByFirstNameContainingIgnoreCase(String firstName);
	List<User> findByLastNameContainingIgnoreCase(String lastName);
}