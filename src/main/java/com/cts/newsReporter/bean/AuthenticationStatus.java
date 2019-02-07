package com.cts.newsReporter.bean;

public class AuthenticationStatus {
	private boolean authenticated;
	private boolean admin;
	
	private User  user;

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public AuthenticationStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "AuthenticationStatus [authenticated=" + authenticated + ", admin=" + admin + ", user=" + user + "]";
	}

}
