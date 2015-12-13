package org.reseau.social.dao;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.reseau.social.entities.Message;
import org.reseau.social.entities.User;
import org.reseau.social.entities.Utilisateur;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor=Throwable.class)
public class SocialDaoImpl implements SocialDao {
	@PersistenceContext
	private EntityManager em;

	public void addClient(User u) {
		em.persist(u);
		em.flush();
	}

	public void addUser(Utilisateur u) {
		em.persist(u);
		em.flush();
	}
	
	
	@Override
	public Message addMessage(Message m) {
		em.persist(m);
		return m;
	}

	@Override
	public ArrayList<Message> getMessages() {
		String hql = "FROM Message";
		Query req = em.createQuery(hql);
		ArrayList<Message> resultList = (ArrayList<Message>) req.getResultList();
		return resultList;
	}

	@Override
	public ArrayList<Message> getMessageByHashtag(String hashtag) {
		String hql = "FROM Message";
		Query req = em.createQuery(hql);
		Collection<Message> liste = req.getResultList();
		Iterator<Message> it = liste.iterator();
		ArrayList<Message> maListe = new ArrayList<Message>();
		while (it.hasNext()){
		  Message m = it.next();
		  if(m.getHashtags().contains(hashtag))
			  maListe.add(m);
		}
		return maListe;
	}

	@Override
	public ArrayList<Message> getMessageByUser(String login) {
		String hql = "FROM Message m WHERE m.user.login=:x";
		Query req = em.createQuery(hql);
		req.setParameter("x", login);
		ArrayList<Message> resultList = (ArrayList<Message>) req.getResultList();
		return resultList;
	}

	@Override
	public User consulterUser(String login) {
		User user = em.find(User.class, login);
		return user;
	}

	@Override
	public ArrayList<User> getUsers() {
		String hql = "FROM User";
		Query req = em.createQuery(hql);
		ArrayList<User> resultList = (ArrayList<User>) req.getResultList();		
		return resultList;
	}
	

}
