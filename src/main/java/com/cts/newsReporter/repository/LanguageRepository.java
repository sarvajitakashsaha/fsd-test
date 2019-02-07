package com.cts.newsReporter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.newsReporter.bean.Language;

@Repository
public interface LanguageRepository extends JpaRepository <Language, Integer> {
	public Language findById(int id);
}
