package com.cts.newsReporter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.newsReporter.bean.Language;
import com.cts.newsReporter.repository.LanguageRepository;

@Service
public class LanguageService {
	@Autowired
	private LanguageRepository languageRepository;
	
	@Transactional
	public List<Language> findLanguage() {
	
		List<Language> language =languageRepository.findAll();

		return language;

	}

}
