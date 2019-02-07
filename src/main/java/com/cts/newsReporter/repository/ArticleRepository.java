package com.cts.newsReporter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.newsReporter.bean.Article;

@Repository 
public interface ArticleRepository extends JpaRepository <Article, Integer> {
	
	public Article findById(int id);
	public Article findByTitle(String title);

}
