package com.aht.service;

import java.util.List;

import org.aspectj.apache.bcel.classfile.Module.Uses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.aht.model.Users;
import com.aht.repository.RoleRepository;
import com.aht.repository.RoleUserRepository;
import com.aht.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private RoleUserRepository ruRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	@Autowired
	private AuthenticationManager authenticationManager;

	public Users findByUserName(String userName) {
		return userRepository.findByUsername(userName);
	}

	public List<Users> getAll() {

		return userRepository.findAll();
	}

	public void createUser(Users user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepository.findByRolename("USER"));
//		user.setRoles(new ArrayList<Role>(roleRepository.findAll()));
		userRepository.save(user);
	}

	public Users getById(int id) {
		return userRepository.findById(id).get();
	}

	public Users changePassword(Users user) {
		Users newUser = userRepository.findById(user.getId()).get();
		newUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRepository.save(newUser);
	}

	public void forgotPassword() {

	}

	public void autoLogin(String username, String password) {
		UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				userDetails, password, userDetails.getAuthorities());
		authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		if (usernamePasswordAuthenticationToken.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			System.out.println("Login success");
		}
	}

}
