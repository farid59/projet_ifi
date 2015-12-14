package org.reseau.social.models;

public class SuscribeUserForm {

	public String loginUser1;
	public String loginUser2;

	public SuscribeUserForm() {
		super();
	}
	
	public SuscribeUserForm(String loginUser1, String loginUser2) {
		super();
		this.loginUser1 = loginUser1;
		this.loginUser2 = loginUser2;
	}
	
	public String getLoginUser1() {
		return loginUser1;
	}
	public void setLoginUser1(String loginUser1) {
		this.loginUser1 = loginUser1;
	}
	public String getLoginUser2() {
		return loginUser2;
	}
	public void setLoginUser2(String loginUser2) {
		this.loginUser2 = loginUser2;
	}

	
}