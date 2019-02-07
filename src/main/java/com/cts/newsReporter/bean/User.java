package com.cts.newsReporter.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;




@Entity
@Table(name = "user")
@NamedQueries({
		@NamedQuery(name = "User.fetchUserDetailsByEmail",
				query = "select u from User u where u.email= :email")
})
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "us_id")
	private int id;

	@Column(name = "us_name")
	@NotNull(message = "Name cannot be empty")
	@Size(min = 2, max = 40, message = "Name must be 2 to 40 characters")
	private String name;

	@Column(name = "us_email")
	@NotNull(message = "Email cannot be empty")
	@Size(min = 2, max = 40, message = "Email must be 2 to 8 characters")
	private String email;

	@Column(name = "us_password")
	@NotNull(message = "Password cannot "
			+ "be empty")
	@Size(min = 2, max = 40, message = "Password must be 2 to 8 characters")
	private String password;
	
	@Column(name = "us_status")
	private boolean status;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "us_ro_id")
	private Role role;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "us_la_id")
	private Language language;
	

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "favorite_article", joinColumns = { @JoinColumn(name = "fa_us_id") }, inverseJoinColumns = {
			@JoinColumn(name = "fa_ar_id") })
	private List<Article> article;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public Language getLanguage() {
		return language;
	}


	public void setLanguage(Language language) {
		this.language = language;
	}


	public List<Article> getArticle() {
		return article;
	}


	public void setArticle(List<Article> article) {
		this.article = article;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", status="
				+ status + ", role=" + role + ", language=" + language + ", article=" + article + "]";
	}
	

}
