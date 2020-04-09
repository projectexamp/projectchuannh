package com.aht.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aht.model.Users;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<Users, Integer> {
	Users findByUsername(String username);

	@Query("SELECT u from Users u WHERE u.username LIKE %:userName%")
	List<Users> findByUserName(@Param(value = "userName") String username);
}
