package org.reseau.social.models;

public class SuscribeHashtagForm {
	public String loginUser;
	public String hashtag;
	
	public SuscribeHashtagForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SuscribeHashtagForm(String loginUser, String hashtag) {
		super();
		this.loginUser = loginUser;
		this.hashtag = hashtag;
	}
	
	public String getLoginUser() {
		return loginUser;
	}
	
	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}
	
	public String getHashtag() {
		return hashtag;
	}
	
	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}
	
}