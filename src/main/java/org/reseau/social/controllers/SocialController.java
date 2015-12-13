package org.reseau.social.controllers;

import java.util.ArrayList;

import org.reseau.social.entities.Message;
import org.reseau.social.metier.SocialMetier;
import org.reseau.social.models.MessageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SocialController {
	@Autowired
	private SocialMetier metier;
	
	@RequestMapping(value="/index")
	public String index(Model model){
		model.addAttribute("MessageForm", new MessageForm());
		return "social";
	}
	
	@RequestMapping(value="/chargerMessage")
	public String charger(MessageForm mf, Model model){
		ArrayList<Message> m = metier.getMessageByHashtag(mf.getHashtag());	
		System.out.println(m.get(0).getContent());
		mf.setMsg(m);
		model.addAttribute("MessageForm",mf);
		return "social";
	}
}
