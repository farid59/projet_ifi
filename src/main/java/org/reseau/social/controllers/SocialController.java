package org.reseau.social.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.reseau.social.entities.Message;
import org.reseau.social.entities.User;
import org.reseau.social.metier.SocialMetier;
import org.reseau.social.models.NewMessageForm;
import org.reseau.social.models.SuscribeHashtagForm;
import org.reseau.social.models.SuscribeUserForm;
import org.reseau.social.models.UserForm;
import org.reseau.social.models.profilForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

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
		model.addAttribute("UserForm",uf);
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
		SuscribeHashtagForm shf = new SuscribeHashtagForm();
		shf.setHashtag(hashtag);
		ArrayList<User> users = metier.getUsers();
		UserForm uf = new UserForm();
		model.addAttribute("UserForm",uf);
		model.addAttribute("hashtag",hashtag);
		model.addAttribute("messages",m);
		model.addAttribute("SuscribeHashtagForm",shf);
		model.addAttribute("users",users);
		return "messagesHashtag";
	}
	
	@RequestMapping(value="/messages/user/{user}")
	public String recupererMessageUser(@PathVariable String user, Model model) {
		ArrayList<Message> m = metier.getMessageByUser(user);	
		UserForm uf = new UserForm();
		ArrayList<User> users = metier.getUsers();
		SuscribeUserForm suf = new SuscribeUserForm();
		suf.setLoginUser2(user);
		model.addAttribute("SuscribeUserForm",suf);
		model.addAttribute("users",users);
		model.addAttribute("UserForm",uf);
		model.addAttribute("user",user);
		model.addAttribute("messages",m);
		return "messagesUser";
	}
	
	@RequestMapping(value="/suscribeHashtag")
	public String suscribeHashtag(SuscribeHashtagForm shf, Model model) {
		User user = metier.consulterUser(shf.getLoginUser());
		String hashtag = shf.getHashtag();
		String OldHashtags = metier.getHashtagsByUser(user);
		String tousLesHashtags;
		if(OldHashtags==null)
			tousLesHashtags = metier.subscribeHashtag(user, hashtag);
		else
			tousLesHashtags = metier.subscribeHashtag(user, OldHashtags+";"+hashtag);		
		ArrayList<Message> m = metier.getMessageByHashtag(hashtag);	
		shf.setHashtag(hashtag);
		ArrayList<User> users = metier.getUsers();
		UserForm uf = new UserForm();
		model.addAttribute("UserForm",uf);
		model.addAttribute("hashtag",hashtag);
		model.addAttribute("messages",m);
		model.addAttribute("SuscribeHashtagForm",shf);
		model.addAttribute("users",users);
		return "messagesHashtag";
	}

	@RequestMapping(value="/suscribeUser")
	public String suscribeUser(SuscribeUserForm suf, Model model) {
		User user1 = metier.consulterUser(suf.getLoginUser1());
		String user2 = suf.getLoginUser2();
		System.out.println(user1.getLogin()+"  et  "+user2);;
		String OldUsers = metier.getUsersByUser(user1);
		String tousLesUsers;
		if(OldUsers==null)
			tousLesUsers = metier.subscribeUser(user1, user2);
		else
			tousLesUsers = metier.subscribeUser(user1, OldUsers+";"+user2);		
		ArrayList<Message> m = metier.getMessageByUser(user1.getLogin());	
		suf.setLoginUser1(user1.getLogin());
		ArrayList<User> users = metier.getUsers();
		UserForm uf = new UserForm();
		model.addAttribute("UserForm",uf);
		model.addAttribute("user",user1.getLogin());
		model.addAttribute("messages",m);
		model.addAttribute("SuscribeUserForm",suf);
		model.addAttribute("users",users);
		return "messagesUser";
	}
	
	@RequestMapping(value="/profil")
	public String manipulerProfilUser(Model model, UserForm uf) {
		System.out.println(uf.getLogin());
		User usr = metier.consulterUser(uf.getLogin()); 	
		ArrayList<User> users = metier.getUsers();
		List<String> hashtags = usr.getHashtagsToArray();
		long nb = metier.countMessagesByUser(usr);
		long nbFollower = metier.nbFollower(usr);
		String linkMessageUser = "/social/messages/user/"+uf.getLogin();
		String linkAbonner="/social/suscribeUser";
		String linkDesabonner="/social/unSuscribeUser";
		String lesusers = metier.getUsersByUser(usr);
		List followers = new ArrayList<String>(Arrays.asList(lesusers.split(";")));
		String linkModifUser="/social/editUser";
		model.addAttribute("urlModifier",linkModifUser);
		model.addAttribute("urlMsg",linkMessageUser);
		model.addAttribute("nb",nb);
		model.addAttribute("UserForm",uf);
		model.addAttribute("users",users);
		model.addAttribute("user",usr);
		model.addAttribute("hashtags",hashtags);
		model.addAttribute("nbFollower",nbFollower);
		model.addAttribute("abonner",linkAbonner);
		model.addAttribute("desabonner",linkDesabonner);
		model.addAttribute("followers",followers);
		return "user";
	}
	
	
	@RequestMapping(value="/modifProfil")
	public String modifierProfilUser(Model model, UserForm uf) {
		String login = uf.getLogin();
		User user = metier.consulterUser(login);
		model.addAttribute("user",user);
		model.addAttribute("UserForm",uf);
		return "profil";
	}
	
	@RequestMapping(value="/editProfil")
	public String modifierProfilUser(Model model, profilForm pf) {
		String login = pf.getLogin();
		User usr = metier.consulterUser(login);
		String nom=pf.getNom();
		String prenom=pf.getPrenom();
		String email=pf.getEmail();
		
		long mobile=pf.getPhoneNumber();
		usr.setEmail(email);
		usr.setNom(nom);
		usr.setPhoneNumber(mobile);
		usr.setPrenom(prenom);
		metier.updateProfil(usr);
		//metier.editProfil(login, nom, prenom, email, mobile);
		return this.index(model);
	}
	

}
