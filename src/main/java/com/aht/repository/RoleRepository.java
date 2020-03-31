package com.aht.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aht.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
