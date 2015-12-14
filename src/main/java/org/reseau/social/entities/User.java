package org.reseau.social.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class User implements Serializable {
	@Id
	private String login;
	private String email;
	private String nom;
	private String prenom;
	private long phoneNumber;
	private int tweeterId;
	private int facebookId;
	private int linkedinId;
	//@ElementCollection
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	private Collection<Message> messages;
	@Lob
	private byte[] photo;
	private String imagePath;
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	private String hashtags;
	private String users;

	public String getHashtags() {
		return hashtags;
	}

	public void setHashtags(String hashtags) {
		this.hashtags = hashtags;
	}

	public Set<String> getSuscribedHashtags() {
		return suscribedHashtags;
	}

	public void setSuscribedHashtags(Set<String> suscribedHashtags) {
		this.suscribedHashtags = suscribedHashtags;
	}

	public Set<String> getSuscribedUsers() {
		return suscribedUsers;
	}

	public void setSuscribedUsers(Set<String> suscribedUsers) {
		this.suscribedUsers = suscribedUsers;
	}

	@ElementCollection(fetch = FetchType.EAGER)
	private Set<String> suscribedHashtags;

	@ElementCollection
	private Set<String> suscribedUsers;

	public User(String login, String nom, String prenom,String email, long phoneNumber) {
		super();
		this.login = login;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.phoneNumber = phoneNumber;
		this.messages = new HashSet<Message>();
		this.suscribedHashtags = new HashSet<String>();
		this.suscribedUsers = new HashSet<String>();
		this.hashtags="";
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
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
		this.hashtags = "";
	}
	

	public User() {
		super();
	}
	
	public List<String> getHashtagsToArray(){
		if(this.hashtags==null)
			return null;
		else {
		List<String> hash = new ArrayList<String>(Arrays.asList(this.hashtags.split(";")));
		return hash;
		}
	}
	public String suscribeHashtag(String hashtag) {
		if(this.hashtags==null)
			this.hashtags = hashtag;
		else {
			List<String> hash = new ArrayList<String>(Arrays.asList(this.hashtags.split(";")));
			if (!hash.contains(hashtag)) {
				hash.add(hashtag);
			}
			if (!hash.contains(hashtag)) {
				hash.add(hashtag);
			}
			String listString = "";
			Iterator<String> it = hash.iterator();
			while(it.hasNext()){
				listString = it.next()+";";
			}
			listString.subSequence(0, listString.length()-1);
			System.out.println(listString);
			this.hashtags = listString;
		}
		return this.hashtags;
	}
	
	
	public List<String> getUsersToArray(){
		if(this.users==null)
			return null;
		else {
		List<String> users = new ArrayList<String>(Arrays.asList(this.users.split(";")));
		return users;
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