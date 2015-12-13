package org.reseau.social.controllers;

import java.util.ArrayList;

import org.reseau.social.entities.Message;
import org.reseau.social.entities.User;
import org.reseau.social.metier.SocialMetier;
import org.reseau.social.models.MessageForm;
import org.reseau.social.models.NewMessageForm;
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
		model.addAttribute("NewMessageForm",nmf);
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
		model.addAttribute("hashtag",hashtag);
		model.addAttribute("messages",m);
		return "messagesHashtag";
	}
	
	@RequestMapping(value="/messages/user/{user}")
	public String recupererMessageUser(@PathVariable String user, Model model) {
		ArrayList<Message> m = metier.getMessageByUser(user);	
		model.addAttribute("user",user);
		model.addAttribute("messages",m);
		return "messagesUser";
	}
}
