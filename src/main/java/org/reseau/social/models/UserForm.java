package org.reseau.social.models;


public class UserForm {
	public String login;

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String loginUser) {
		this.login = loginUser;
	}

	public UserForm(String loginUser) {
		super();
		this.login = loginUser;
	}

	public UserForm() {
		super();
	}
	


	
	
}
