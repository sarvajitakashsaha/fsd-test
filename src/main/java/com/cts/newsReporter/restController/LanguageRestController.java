package com.cts.newsReporter.restController;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.newsReporter.bean.Language;

import com.cts.newsReporter.service.LanguageService;

@RestController

public class LanguageRestController extends ExceptionController{
	private static final Logger LOGGER = LoggerFactory.getLogger(LanguageRestController.class);
	@Autowired
	private LanguageService languageService;
	
	@GetMapping("/language")
	public List<Language> listofLanguage() {
		LOGGER.info(" START");
		List<Language>  language = languageService.findLanguage();
	
		LOGGER.info("END");
		return language;
	}
	
}
