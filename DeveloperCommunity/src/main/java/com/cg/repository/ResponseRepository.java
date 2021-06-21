package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entity.Response;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Integer> {
	@Query("from Response r where r.respId=?1")
	Response getById(int respId);
}
