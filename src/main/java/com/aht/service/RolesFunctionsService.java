package com.aht.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aht.model.RolesFunctions;
import com.aht.repository.RoleRepository;
import com.aht.repository.RolesFunctionsRepository;

@Service
public class RolesFunctionsService {
	@Autowired
	private RolesFunctionsRepository rfReposiotry;
	@Autowired
	private RoleRepository rReposiotry;

	public RolesFunctions create(RolesFunctions rf) {
		RolesFunctions myRF = new RolesFunctions();
		myRF.setFunctions(rf.getFunctions());
		myRF.setRoles(rReposiotry.findById(5).get());
		return rfReposiotry.save(myRF);
	}
}
