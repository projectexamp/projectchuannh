package com.aht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aht.model.Users;
import com.aht.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public Users findByUserName(String userName) {
		return userRepository.findByUsername(userName);
	}

	public List<Users> getAll() {

		return userRepository.findAll();
	}
}
