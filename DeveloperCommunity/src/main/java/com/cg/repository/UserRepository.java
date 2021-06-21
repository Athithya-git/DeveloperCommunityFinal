package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
	@Query("from Users u where u.userId= :userId ")
	public Users getById(@Param("userId") String userId);

}
