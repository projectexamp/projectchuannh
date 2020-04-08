package com.aht.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aht.model.RolesUsers;
import com.aht.repository.RoleUserRepository;

@Service
public class RolesUsersService {
	@Autowired
	private RoleUserRepository ruRepository;

	public RolesUsers create(RolesUsers rf) {
		RolesUsers myRu = new RolesUsers();
		myRu.setRole(rf.getRole());
		myRu.setUser(rf.getUser());
		return ruRepository.save(myRu);
	}
}
