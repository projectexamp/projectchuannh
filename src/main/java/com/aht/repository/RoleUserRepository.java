package com.aht.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aht.model.RolesUsers;

@Repository
@Transactional
public interface RoleUserRepository extends JpaRepository<RolesUsers, Integer> {
	@Query(value = "SELECT ru FROM RolesUsers ru WHERE ru.user.id = :userId")
	List<RolesUsers> findByUserId(@Param("userId") int userId);
}
