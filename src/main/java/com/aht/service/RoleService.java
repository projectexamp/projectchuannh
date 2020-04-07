package com.aht.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aht.model.Role;
import com.aht.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	public List<Role> getAll() {

		return roleRepository.findAll();
	}

	public Role createRole(Role role) {
		Role myRole = new Role();
		myRole.setStatus(0);
		myRole.setRoleName(role.getRoleName());
		myRole.setDescription(role.getDescription());
		myRole.setRoleCode("ROLE_" + role.getRoleCode());
		myRole.setRoleOrder(role.getRoleOrder());

		return roleRepository.save(myRole);
	}

	public Role updateRole(Role role) {
		Role myRole = roleRepository.findById(role.getId()).get();
		myRole.setRoleName(role.getRoleName());
		myRole.setDescription(role.getDescription());
		myRole.setRoleCode(role.getRoleCode());
		myRole.setRoleOrder(role.getRoleOrder());

		return roleRepository.save(myRole);

	}

	public void deleteRole(int id) {
		roleRepository.delete(roleRepository.findById(id).get());
	}

	public Role getById(int id) {
		Optional<Role> role = roleRepository.findById(id);
		if (role.isPresent())
			return role.get();
		return null;
	}

	public Role activeRole(int id) {
		Role myRole = roleRepository.findById(id).get();
		myRole.setStatus(0);
		return roleRepository.save(myRole);
	}

	public Role disableRole(int id) {
		Role myRole = roleRepository.findById(id).get();
		myRole.setStatus(1);
		return roleRepository.save(myRole);
	}

	public Role delRole(int id) {
		Role myRole = roleRepository.findById(id).get();
		myRole.setStatus(2);
		return roleRepository.save(myRole);
	}
}
