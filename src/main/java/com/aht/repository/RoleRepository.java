package com.aht.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aht.model.Role;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role, Long> {
	@Query("SELECT r FROM Role r WHERE r.roleName = 'ROLE_USER'")
	public List<Role> findByRolename(String name);
}
