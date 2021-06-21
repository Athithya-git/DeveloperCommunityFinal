package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entity.Developer;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {
	@Query("from Developer d where d.devId=?1")
	Developer getById(int devId);

}
