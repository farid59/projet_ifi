package org.reseau.social.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class User implements Serializable {
	@Id
	private String login;
	private String email;
	private long phoneNumber;
	private int tweeterId;
	private int facebookId;
	private int linkedinId;
	//@ElementCollection
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	private Collection<Message> messages;
	@Lob
	private byte[] photo;
	

	@ElementCollection
	public Set<String> suscribedHashtags;
	@ElementCollection
	public Set<String> suscribedUsers;

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getTweeterId() {
		return tweeterId;
	}

	public void setTweeterId(int tweeterId) {
		this.tweeterId = tweeterId;
	}

	public int getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(int facebookId) {
		this.facebookId = facebookId;
	}

	public int getLinkedinId() {
		return linkedinId;
	}

	public void setLinkedinId(int linkedinId) {
		this.linkedinId = linkedinId;
	}

	public Collection<Message> getMessages() {
		return messages;
	}

	public void setMessages(Collection<Message> messages) {
		this.messages = messages;
	}

	public User(String login, String email, long phoneNumber) {
		super();
		this.login = login;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.messages = new HashSet<Message>();
		this.suscribedHashtags = new HashSet<String>();
		this.suscribedUsers = new HashSet<String>();
	}
	

	public User() {
		super();
	}
	
	public void suscribeHashtag(String hashtag) {
		if (!this.suscribedHashtags.contains(hashtag)) {
			this.suscribedHashtags.add(hashtag);
		}
	}
	
	public void unsuscribeHashtag(String hashtag) {
		if (this.suscribedHashtags.contains(hashtag)) {
			this.suscribedHashtags.remove(hashtag);
		}
	}
	
	public void suscribeUser(String user) {
		if (!this.suscribedUsers.contains(user)) {
			this.suscribedUsers.add(user);
		}
	}
	
	public void unsuscribeUser(String user) {
		if (this.suscribedUsers.contains(user)) {
			this.suscribedUsers.remove(user);
		}
	}

}