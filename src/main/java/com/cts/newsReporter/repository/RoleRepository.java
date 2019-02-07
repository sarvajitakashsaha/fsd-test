package com.cts.newsReporter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.newsReporter.bean.Role;

@Repository
public interface RoleRepository  extends JpaRepository <Role, Integer> {
	public Role findById(int id);
}
