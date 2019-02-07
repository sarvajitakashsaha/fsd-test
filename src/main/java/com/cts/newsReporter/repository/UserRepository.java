package com.cts.newsReporter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.newsReporter.bean.User;
@Repository
public interface UserRepository extends JpaRepository <User, Integer> {
	public User fetchUserDetailsByEmail(@Param("email") String email);
	
	public User findById(int id);
	

}
