package org.reseau.social.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Message implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @NotEmpty
    @Size(min=4,max=150)
	private String content;
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;
	@ElementCollection
	private Set<String> hashtags;
	@ElementCollection
	private Set<String> users;
	private Date dateCreation;
	
	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Message() {
		super();
	}

	public Message(String content) {
		super();
		this.content = content;
		this.hashtags = new HashSet<String>(); 
		this.users = new HashSet<String>(); 
		this.dateCreation = new Date();
	}

	public Message(String content, User user) {
		super();
		this.content = content;
		this.user = user;
		this.hashtags = new HashSet<String>(); 
		this.users = new HashSet<String>(); 
		this.dateCreation = new Date();
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Set<String> getHashtags() {
		return hashtags;
	}

	public void setHashtags(Set<String> hashtags) {
		this.hashtags = hashtags;
	}

	public Set<String> getUsers() {
		return users;
	}

	public void setUsers(Set<String> users) {
		this.users = users;
	}

	public void parse() {
		String[] words = this.content.split(" ");
		for (String word : words) {
			if (word.subSequence(0,1).equals("#")) {
				String tag = word.substring(1);
				if (!this.hashtags.contains(tag)) {
					this.hashtags.add(tag);					
				}
			} else if (word.subSequence(0,1).equals("@")) {
				String user = word.substring(1);				
				if (!this.users.contains(user)) {
					this.users.add(user);					
				}
			} 
		}
	}
	
	
}
