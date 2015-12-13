package org.reseau.social.metier;

import java.util.ArrayList;

import org.reseau.social.dao.SocialDao;
import org.reseau.social.entities.Message;
import org.reseau.social.entities.User;
import org.reseau.social.entities.Utilisateur;
import org.springframework.transaction.annotation.Transactional;

public class SocialMetierImpl implements SocialMetier{
	
	private SocialDao dao;
	
	public void setDao(SocialDao dao){
		this.dao = dao;
	}
	
	@Override
	public void addClient(User u) {
		dao.addClient(u);
	}

	@Override
	public Message addMessage(Message m) {
		return dao.addMessage(m);
	}

	@Override
	public ArrayList<Message> getMessages() {
		return dao.getMessages();
	}

	@Override
	public ArrayList<Message> getMessageByHashtag(String hashtag) {
		return dao.getMessageByHashtag(hashtag);
	}

	@Override
	public ArrayList<Message> getMessageByUser(String login) {
		return dao.getMessageByUser(login);
	}

	@Override
	public User consulterUser(String login) {
		return dao.consulterUser(login);
	}

	@Override
	public ArrayList<User> getUsers() {
		return dao.getUsers();
	}

	@Override
	public void addUser(Utilisateur util) {
		dao.addUser(util);		
	}

}
