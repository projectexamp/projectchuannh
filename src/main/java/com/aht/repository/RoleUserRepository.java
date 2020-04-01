package com.aht.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aht.model.RoleUser;

@Repository
@Transactional
public interface RoleUserRepository extends JpaRepository<RoleUser, Integer> {

}
