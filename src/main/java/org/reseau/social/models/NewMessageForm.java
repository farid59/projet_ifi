package org.reseau.social.models;

public class NewMessageForm {
	public String loginUser;
	public String content;
	
	public NewMessageForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewMessageForm(String loginUser, String content) {
		super();
		this.loginUser = loginUser;
		this.content = content;
	}


	public String getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	
}
