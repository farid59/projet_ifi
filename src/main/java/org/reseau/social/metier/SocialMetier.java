package org.reseau.social.metier;

import java.util.ArrayList;

import org.reseau.social.entities.Message;
import org.reseau.social.entities.User;
import org.reseau.social.entities.Utilisateur;

public interface SocialMetier {
	public void addClient(User u);
	public Message addMessage(Message m);
	public ArrayList<Message> getMessages();
	public ArrayList<Message> getMessageByHashtag(String hashtag);
	public ArrayList<Message> getMessageByUser(String login);
	public User consulterUser(String login);
	public ArrayList<User> getUsers();
	public void addUser(Utilisateur util);
	public String subscribeHashtag(User user,String hashtag);
	public String getHashtagsByUser(User user);
	public long countMessagesByUser(User user);
	public String subscribeUser(User user1, String user2);
	public String getUsersByUser(User user);
	public long nbFollower(User usr);
	public void editProfil(String login, String nom,String prenom,String email,long mobile);
	public void updateProfil(User usr);


}
