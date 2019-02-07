package com.cts.newsReporter.restController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.newsReporter.bean.ArticleStatus;
import com.cts.newsReporter.bean.SignupStatus;
import com.cts.newsReporter.bean.User;
import com.cts.newsReporter.service.UserService;

@RestController
@RequestMapping("/user")
public class UserRestController  extends ExceptionController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserRestController.class);
	@Autowired
	private UserService userService;

	@PostMapping("/save")
	public SignupStatus saveUser(@RequestBody User user) {
		
		
		System.out.println("language"+ user.getLanguage());
		LOGGER.info(" START");
		LOGGER.debug("user status is : {} ", user);
		SignupStatus status = new SignupStatus();
		status = userService.save(user);
		LOGGER.debug("final status is : {} ", status);
		LOGGER.info("END");
		return status;
	}

	@GetMapping("/analyst/{email}")
	public User findAnalyst(@PathVariable("email") String email) {
		LOGGER.info(" START");
		User user = new User();
		user = userService.findAnalyst(email);
		LOGGER.debug("employee : {} ", user);
		LOGGER.info("END");
		return user;

	}

	@GetMapping("/saveuser/{email}")
	public User saveAnalyst(@PathVariable("email") String email) {
		LOGGER.info("email");
		User user = userService.saveAnalystStatus(email);

		LOGGER.info("seat");
		return user;
	}

	@PostMapping("/savearticle")
	public ArticleStatus saveArticle(@RequestBody User user) {
		ArticleStatus articleStatus = new ArticleStatus();
		System.out.println(user);
		articleStatus = userService.setArticleListForOneUser(user);
		return articleStatus;
	

	}

	@PostMapping("/removerticle")
	public ArticleStatus removeArticle(@RequestBody User user) {
		ArticleStatus articleStatus = new ArticleStatus();
		System.out.println(user);
		articleStatus = userService.deleteArticleListForOneUser(user);
		return articleStatus;
	

	}
}
