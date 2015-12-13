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
}
