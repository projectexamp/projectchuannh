package com.aht.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aht.model.Role;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role, Integer> {
	@Query("SELECT r FROM Role r WHERE r.roleCode = 'ROLE_USER'")
	public List<Role> findByRolecode(String name);

	@Query(value = "SELECT r FROM Role r WHERE r.roleName LIKE %:roleName%", nativeQuery = false)
	public List<Role> findByRoleName(@Param(value = "roleName") String roleName);
}
