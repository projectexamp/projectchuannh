package com.aht.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aht.model.Users;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<Users, Integer> {
	Users findByUsername(String username);

}
