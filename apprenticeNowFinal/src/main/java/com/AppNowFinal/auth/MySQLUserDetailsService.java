package com.AppNowFinal.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.AppNowFinal.models.User;

@Service
public class MySQLUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public UserDetails loadUserByUsername(String email) {
		User user = userRepository.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException(email);
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthorities());
	}

	public UserDetails Save(User newUser) {
		newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
		User savedUser = userRepository.save(newUser);
		return new org.springframework.security.core.userdetails.User(savedUser.getEmail(), savedUser.getPassword(), getAuthorities());
	}

	private List<SimpleGrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authList = new ArrayList<>();
		authList.add(new SimpleGrantedAuthority("ROLE_USER"));
		return authList;
	}
}