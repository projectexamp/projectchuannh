package com.aht.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.aht.model.Function;
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

	public void createAccount(Users user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepository.findByRolename("USER"));
//		user.setRoles(new ArrayList<Role>(roleRepository.findAll()));
		userRepository.save(user);
	}

	public Users getById(int id) {
		Optional<Users> user = userRepository.findById(id);
		if (user.isPresent())
			return user.get();
		return null;
	}

//	public Users getById(int id) {
//		return userRepository.findById(id).get();
//	}

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

	public Users createUser(Users user) {
		Users myUser = new Users();
		myUser.setStatus(0);
		myUser.setFullName(user.getFullName());
		myUser.setUsername(user.getUsername());
		myUser.setPassword(user.getPassword());
		myUser.setGender(user.getGender());
		return userRepository.save(myUser);
	}

	public Users updateUser(Users oldUser) {
		Users myUser = userRepository.findById(oldUser.getId()).get();
		myUser.setFullName(oldUser.getFullName());
//		myUser.setPassword(oldUser.getPassword());
		myUser.setGender(oldUser.getGender());
		return userRepository.save(myUser);
	}

	public boolean deleteUser(int id) {
		userRepository.delete(userRepository.findById(id).get());
		return true;
	}

	public Users activeUser(int id) {
		Users myUser = userRepository.findById(id).get();
		myUser.setStatus(0);
		return userRepository.save(myUser);
	}

	public Users disableUser(int id) {
		Users myUser = userRepository.findById(id).get();
		myUser.setStatus(1);
		return userRepository.save(myUser);
	}

	public Users delUsers2(int id) {
		Users myUser = userRepository.findById(id).get();
		myUser.setStatus(2);
		return userRepository.save(myUser);
	}
}
