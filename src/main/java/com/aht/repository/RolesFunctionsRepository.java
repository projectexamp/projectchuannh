package com.aht.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aht.model.RolesFunctions;

@Repository
@Transactional
public interface RolesFunctionsRepository extends JpaRepository<RolesFunctions, Integer> {
	@Query(value = "SELECT rf FROM RolesFunctions rf WHERE rf.role.id = :roleId ")
	List<RolesFunctions> getListByRoleId(@Param(value = "roleId") int roleId);
}
