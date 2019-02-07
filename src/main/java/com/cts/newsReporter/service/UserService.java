package com.cts.newsReporter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.newsReporter.bean.Article;
import com.cts.newsReporter.bean.ArticleStatus;
import com.cts.newsReporter.bean.Language;
import com.cts.newsReporter.bean.Role;
import com.cts.newsReporter.bean.SignupStatus;
import com.cts.newsReporter.bean.User;
import com.cts.newsReporter.repository.ArticleRepository;
import com.cts.newsReporter.repository.LanguageRepository;
import com.cts.newsReporter.repository.RoleRepository;
import com.cts.newsReporter.repository.UserRepository;

@Service
public class UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private LanguageRepository languageRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private ArticleRepository articleRepository;


	@Transactional
	public User findAnalyst(String email) {
		LOGGER.info("START");

		User user = userRepository.fetchUserDetailsByEmail(email);
		if (user.getRole().getId() == 2) {
			LOGGER.debug("news Reporter details: {} ", user);
			LOGGER.info("END");
			return user;
		} else
			return null;

	}

	@Transactional
	public SignupStatus save(User user) {

		LOGGER.info(" START");

		LOGGER.info("User {} ", user);
		SignupStatus status = new SignupStatus();
		User previousUser = userRepository.fetchUserDetailsByEmail(user.getEmail());

		if (previousUser == null) {
			Role role = roleRepository.findById(2);
			user.setRole(role);
			Language language = languageRepository.findById(user.getLanguage().getId());
			user.setLanguage(language);
			user.setStatus(true);
			userRepository.save(user);
			System.out.println("User " + user);
			status.setEmailExist(false);
			status.setMessege("Email Id not found and User Details saved successfully.");
			status.setSignupStatus(true);

			LOGGER.debug("final status is : {} ", status);
		} else {
			status.setEmailExist(true);
			status.setMessege("Email Id already exists and User Details cannot be saved.");
			status.setSignupStatus(false);
			LOGGER.debug("final status is : {} ", status);
		}

		LOGGER.info("END");

		return status;
	}

	@Transactional
	public User saveAnalystStatus(String email) {
		LOGGER.info("start");
		User user = userRepository.fetchUserDetailsByEmail(email);
		LOGGER.info("news Reporter details: {} ", user);
		if (user.getRole().getId() == 2) {
			if (user.isStatus()) {
				user.setStatus(false);
			} else {
				user.setStatus(true);
			}
			userRepository.save(user);
			LOGGER.info("end");
			return userRepository.fetchUserDetailsByEmail(email);
		}

		else
			return null;
	}

	@Transactional
	public ArticleStatus setArticleListForOneUser(User user) {
		LOGGER.info("Start");
		ArticleStatus articleStatus = new ArticleStatus();
		User previousUser = userRepository.fetchUserDetailsByEmail(user.getEmail());
		LOGGER.debug("actual user is  : {} ", previousUser);
		Article article = user.getArticle().get(0);
		LOGGER.debug("actual article is  : {} ", article);

		Article previousArticle = articleRepository.findByTitle(article.getTitle());
		if (previousArticle == null) {
			articleRepository.save(article);
			Article savedArticle = articleRepository.findByTitle(article.getTitle());
			LOGGER.info("saving new article");
			articleStatus.setArticleExist(false);
			previousUser.getArticle().add(savedArticle);
		} else {
			articleStatus.setArticleExist(true);
			boolean isExists = false;
			for (Article a : previousUser.getArticle()) {
				if (a.getTitle().equals(user.getArticle().get(0).getTitle())) {
					isExists = true;
				}
			}
			if (!isExists) {
				previousUser.getArticle().add(previousArticle);
				articleStatus.setArticleExist(false);
			}
		}
		if (article.getTitle() != null) {
			userRepository.save(previousUser);
		}
		LOGGER.info("End");
		return articleStatus;
	}
	
	
	@Transactional
	public ArticleStatus deleteArticleListForOneUser(User user) {
		LOGGER.info("Start");
		ArticleStatus articleStatus = new ArticleStatus();
		User previousUser = userRepository.fetchUserDetailsByEmail(user.getEmail());
		LOGGER.debug("actual user is  : {} ", previousUser);
		Article article = user.getArticle().get(0);
		LOGGER.debug("actual article is  : {} ", article);

	
		
		for(int i = 0; i<previousUser.getArticle().size();i++) {
			if(previousUser.getArticle().get(i).getTitle().equals(article.getTitle())){
				previousUser.getArticle().remove(previousUser.getArticle().get(i));
			}
		}
		
	
		return articleStatus;
	}
	

}
