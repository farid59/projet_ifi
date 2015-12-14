package org.reseau.social.dao;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
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
		String hql = "FROM Message";
		Query req = em.createQuery(hql);
		Collection<Message> liste = req.getResultList();
		Iterator<Message> it = liste.iterator();
		ArrayList<Message> maListe = new ArrayList<Message>();
		while (it.hasNext()){
		  Message m = it.next();
		  if(m.getUser().getLogin().equals(login)){
			  maListe.add(m);
		  }
		}
		return maListe;
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

	@Override
	public String subscribeHashtag(User user, String hashtag) {
		String hql = "UPDATE User set hashtags =:x WHERE login=:y";
		Query req = em.createQuery(hql);
		req.setParameter("x", hashtag);
		req.setParameter("y", user.getLogin());
		req.executeUpdate();
		return hashtag;
	}

	@Override
	public String getHashtagsByUser(User user) {
		String hql = "SELECT hashtags FROM User u WHERE u.login=:x";
		Query req = em.createQuery(hql);
		req.setParameter("x", user.getLogin());
		String resultList = (String) req.getResultList().get(0);
		if(resultList!=null){
			resultList = (String) resultList.subSequence(0, resultList.length());
			String res = resultList;
			return res;	
		}
		return null;
		
	}
	
	@Override
	public String subscribeUser(User user1, String user2) {
		String hql = "UPDATE User set users =:x WHERE login=:y";
		Query req = em.createQuery(hql);
		req.setParameter("x", user2);
		req.setParameter("y", user1.getLogin());
		req.executeUpdate();
		return user2;
	}
	
	@Override
	public String getUsersByUser(User user) {
		String hql = "SELECT users FROM User u WHERE u.login=:x";
		Query req = em.createQuery(hql);
		req.setParameter("x", user.getLogin());
		String resultList = (String) req.getResultList().get(0);
		if(resultList!=null){
			resultList = (String) resultList.subSequence(0, resultList.length());
			String res = resultList;
			return res;	
		}
		return null;
		
	}

	@Override
	public long countMessagesByUser(User user) {
		String hql = "SELECT count(*) FROM Message m WHERE m.user.login=:x";
		Query req = em.createQuery(hql);
		req.setParameter("x", user.getLogin());
		long nb = (Long) req.getSingleResult();
		return nb;
	}

	@Override
	public long nbFollower(User usr) {
		String hql = "SELECT users FROM User u WHERE u.login=:x";
		Query req = em.createQuery(hql);
		req.setParameter("x", usr.getLogin());
		String resultList = (String) req.getResultList().get(0);
		if(resultList!=null){
			ArrayList<String> list = new ArrayList<String>(Arrays.asList(resultList.split(";")));
			return list.size();
		}
		return 0;
			
	}

	@Override
	public void editProfil(String login, String nom, String prenom, String email, long mobile) {
		String hql = "UPDATE User set email=:y AND nom:=z AND prenom:=a AND phoneNumber:=b WHERE login=:x";
		Query req = em.createQuery(hql);
		req.setParameter("x", login);
		req.setParameter("y", email);
		req.setParameter("z", nom);
		req.setParameter("a", prenom);
		req.setParameter("b", mobile);
		req.executeUpdate();		
	}

	@Override
	public void updateProfil(User usr) {
		em.merge(usr);
		em.flush();
	}

}
