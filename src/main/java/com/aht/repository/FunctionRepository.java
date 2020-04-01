package com.aht.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aht.model.Function;

@Repository
@Transactional
public interface FunctionRepository extends JpaRepository<Function, Integer> {

}
