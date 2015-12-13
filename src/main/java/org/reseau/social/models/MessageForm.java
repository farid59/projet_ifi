package org.reseau.social.models;

import java.util.ArrayList;

import org.reseau.social.entities.Message;
import org.reseau.social.entities.User;

public class MessageForm {
	public String content;
	private User user;
	public ArrayList<Message> msg;
	public String Hashtag;
	
	public String getHashtag() {
		return Hashtag;
	}
	public void setHashtag(String hashtag) {
		Hashtag = hashtag;
	}
	public ArrayList<Message> getMsg() {
		return msg;
	}
	public void setMsg(ArrayList<Message> msg) {
		this.msg = msg;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
