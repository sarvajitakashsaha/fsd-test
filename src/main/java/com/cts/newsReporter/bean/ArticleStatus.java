package com.cts.newsReporter.bean;

public class ArticleStatus {
	private boolean articleExist;	
	private String messege;
	public ArticleStatus(boolean articleExist, String messege) {
		super();
		this.articleExist = articleExist;
		this.messege = messege;
	}
	public boolean isArticleExist() {
		return articleExist;
	}
	public void setArticleExist(boolean articleExist) {
		this.articleExist = articleExist;
	}
	public String getMessege() {
		return messege;
	}
	public void setMessege(String messege) {
		this.messege = messege;
	}
	public ArticleStatus() {
		super();
	}
	
	
	

}
