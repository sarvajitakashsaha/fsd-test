package com.cts.newsReporter.restController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.newsReporter.bean.AuthenticationStatus;
import com.cts.newsReporter.bean.User;
import com.cts.newsReporter.service.LoginService;

@RestController
public class LoginRestController  extends ExceptionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginRestController.class);
	private LoginService loginService;

	@Autowired
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@PostMapping("/authenticate")
	private ResponseEntity<AuthenticationStatus> authenticate(@RequestBody User user) {
		LOGGER.info("Start");
		LOGGER.debug("User :{}", user);
		AuthenticationStatus status = new AuthenticationStatus();
		status.setAuthenticated(false);
		status.setAdmin(false);
		LOGGER.debug("status :{}", status);
		String email = user.getEmail();
		String password = user.getPassword();
		User actualUser = loginService.getUserByEmail(email);
		LOGGER.debug("actualUser :{}", actualUser);
		if (actualUser != null) {
			String actualPassword = actualUser.getPassword();
			LOGGER.debug("actualPassword :{}", actualPassword);
			if (email.equals("admin") && password.equals(actualPassword)) {
				status.setAdmin(true);
				status.setUser(actualUser);
				status.setAuthenticated(true);
			} else {
				
				String actualEmail = user.getEmail();
				status.setUser(actualUser);
				status.setAuthenticated(email.equals(actualEmail));
				status.setAuthenticated(password.equals(actualPassword));
			}

		}

		LOGGER.info("End");

		return new ResponseEntity<AuthenticationStatus>(status, HttpStatus.OK);

	}
}
