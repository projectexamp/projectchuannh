package com.aht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aht.model.RolesFunctions;
import com.aht.repository.RolesFunctionsRepository;

@Service
public class RolesFunctionsService {
	@Autowired
	private RolesFunctionsRepository rfReposiotry;

	public RolesFunctions create(RolesFunctions rf) {
		RolesFunctions myRF = new RolesFunctions();
		myRF.setFunction(rf.getFunction());
		myRF.setRole(rf.getRole());
		return rfReposiotry.save(myRF);
	}

	public List<RolesFunctions> getListByRoleId(int roleId) {

		return rfReposiotry.getListByRoleId(roleId);
	}
}
