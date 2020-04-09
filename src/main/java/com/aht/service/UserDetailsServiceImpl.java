package com.aht.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aht.model.Role;
import com.aht.model.Users;
import com.aht.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository uRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users user = uRepository.findByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException("Khong tim thay tai khoan " + username);
		List<GrantedAuthority> grentedAuthority = new ArrayList<>();
		for (Role role : user.getRoles()) {
			grentedAuthority.add(new SimpleGrantedAuthority(role.getRoleCode()));
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				grentedAuthority);
	}

}
