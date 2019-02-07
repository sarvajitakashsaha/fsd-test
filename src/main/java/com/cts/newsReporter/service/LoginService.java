package com.cts.newsReporter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.newsReporter.bean.User;
import com.cts.newsReporter.repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	private UserRepository UserRepository;

	@Transactional
	public User getUserByEmail(String email) {
		return UserRepository.fetchUserDetailsByEmail(email);

	}
}
