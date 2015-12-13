package test;

import java.util.ArrayList;
import java.util.Iterator;

import org.reseau.social.entities.Message;
import org.reseau.social.entities.User;
import org.reseau.social.metier.SocialMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		SocialMetier metier = (SocialMetier) context.getBean("metier");
		ArrayList<Message> lesMsg = metier.getMessages();
		System.out.println("------------------------ Tous les messages ------------------------ ");
		Iterator<Message> it = lesMsg.iterator();
		while(it.hasNext()){			
			System.out.println(it.next());	
		}
		
		ArrayList<User> lesUsers = metier.getUsers();
		Iterator<User> it2 = lesUsers.iterator();
		System.out.println("------------------------ Tous les users ------------------------ ");
		while(it2.hasNext()){			
			System.out.println(it2.next().getLogin());	
		}
		
		ArrayList<Message> msgByHash = metier.getMessageByHashtag("ennui");
		Iterator<Message> it3 = msgByHash.iterator();
		System.out.println("------------------------ Messages avec #ennui ------------------------ ");
		while(it3.hasNext()){			
			System.out.println(it3.next().getContent());	
		}
		
		ArrayList<Message> msgByUser = metier.getMessageByUser("farid");
		Iterator<Message> it4 = msgByUser.iterator();
		System.out.println("------------------------ Messages de farid ------------------------ ");
		while(it4.hasNext()){			
			System.out.println(it4.next().getContent());	
		}
		ArrayList<Message> msgMohcine = metier.getMessageByUser("Mohcine");
		Iterator<Message> it5 = msgMohcine.iterator();
		System.out.println("------------------------ Messages de Mohcine ------------------------ ");
		while(it5.hasNext()){			
			System.out.println(it5.next().getContent());	
		}
		ArrayList<Message> msgYahia = metier.getMessageByUser("Yahia");
		Iterator<Message> it6 = msgYahia.iterator();
		System.out.println("------------------------ Messages de Yahia ------------------------ ");
		while(it6.hasNext()){			
			System.out.println(it6.next().getContent());	
		}
	}

}
