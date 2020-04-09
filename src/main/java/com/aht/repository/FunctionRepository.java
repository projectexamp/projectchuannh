package com.aht.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aht.model.Function;

@Repository
@Transactional
public interface FunctionRepository extends JpaRepository<Function, Integer> {
	// nativeQuery: true => su dung cho sql; = false dung cho hql
	// SQL
//	@Query(value = "SELECT * FROM TBL_FUNCTION WHERE FUNCTION_NAME LIKE %?1%", nativeQuery = true)
//	@Query(value = "SELECT * FROM TBL_FUNCTION WHERE FUNCTION_NAME LIKE %:functionName%", nativeQuery = true)
	// HQL
//	@Query(value = "SELECT fn FROM Function fn WHERE fn.functionName LIKE %?1%", nativeQuery = false)
	@Query(value = "SELECT fn FROM Function fn WHERE fn.functionName LIKE %:functionName%", nativeQuery = false)
	public List<Function> findByFunctionName(@Param(value = "functionName") String functionName);

}
