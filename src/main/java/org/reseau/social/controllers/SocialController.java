package org.reseau.social.controllers;

import java.util.ArrayList;

import org.reseau.social.entities.Message;
import org.reseau.social.entities.User;
import org.reseau.social.metier.SocialMetier;
import org.reseau.social.models.NewMessageForm;
import org.reseau.social.models.SuscribeHashtagForm;
import org.reseau.social.models.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SocialController {
	@Autowired
	private SocialMetier metier;
	
	@RequestMapping(value="/index")
	public String index(Model model){
		ArrayList<Message> m = metier.getMessages();
		ArrayList<User> users = metier.getUsers();
		NewMessageForm nmf = new NewMessageForm();
		UserForm uf = new UserForm();
		model.addAttribute("NewMessageForm",nmf);
		model.addAttribute("UserForm",uf);
		model.addAttribute("users",users);
		model.addAttribute("messages",m);
		return "social";
	}
	
	@RequestMapping(value="/posterMessage")
	public String poster(NewMessageForm nmf, Model model) {
		User user = metier.consulterUser(nmf.getLoginUser());
		Message message = new Message(nmf.getContent(), user);
		metier.addMessage(message);
		return this.index(model);
	}
	
	@RequestMapping(value="/messages/hashtag/{hashtag}")
	public String recupererMessageHashtag(@PathVariable String hashtag, Model model) {
		ArrayList<Message> m = metier.getMessageByHashtag(hashtag);	
		SuscribeHashtagForm shf = new SuscribeHashtagForm();
		shf.setHashtag(hashtag);
		ArrayList<User> users = metier.getUsers();
		model.addAttribute("hashtag",hashtag);
		model.addAttribute("messages",m);
		model.addAttribute("SuscribeHashtagForm",shf);
		model.addAttribute("users",users);
		return "messagesHashtag";
	}
	
	@RequestMapping(value="/messages/user/{user}")
	public String recupererMessageUser(@PathVariable String user, Model model) {
		ArrayList<Message> m = metier.getMessageByUser(user);	
		model.addAttribute("user",user);
		model.addAttribute("messages",m);
		return "messagesUser";
	}
	
	@RequestMapping(value="/suscribeHashtag")
	public String suscribeHashtag(SuscribeHashtagForm shf, Model model) {
		User user = metier.consulterUser(shf.getLoginUser());
		String hashtag = shf.getHashtag();
		/*
		 * ce code déclenche l'erreur :
		 * Etat HTTP 500 - Request processing failed; nested exception is org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role: org.reseau.social.entities.User.suscribedHashtags, could not initialize proxy - no Session
		 */
//		user.suscribeHashtag(hashtag);
		ArrayList<Message> m = metier.getMessageByHashtag(hashtag);	
		shf.setHashtag(hashtag);
		ArrayList<User> users = metier.getUsers();
		model.addAttribute("hashtag",hashtag);
		model.addAttribute("messages",m);
		model.addAttribute("SuscribeHashtagForm",shf);
		model.addAttribute("users",users);
		return "messagesHashtag";
	}
	
	@RequestMapping(value="/profil")
	public String manipulerProfilUser(Model model, UserForm uf) {
		System.out.println(uf.getLogin());
		User usr = metier.consulterUser(uf.getLogin()); 	
		ArrayList<User> users = metier.getUsers();
		model.addAttribute("UserForm",uf);
		model.addAttribute("users",users);
		model.addAttribute("user",usr);
		return "user";
	}
	
	
}
