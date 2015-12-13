package test;

import org.reseau.social.entities.Message;
import org.reseau.social.entities.User;
import org.reseau.social.entities.Utilisateur;
import org.reseau.social.metier.SocialMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		SocialMetier metier = (SocialMetier) context.getBean("metier");
		User u1 = new User("farid", "test", 124L);
		User u2 = new User("Yahia", "test", 124L);
		User u3 = new User("Mohcine", "test@test.fr", 2345245L);
		metier.addClient(u1);
		metier.addClient(u2);
		metier.addClient(u3);
		Message m1 = new Message("coucou @farid #ennui",u1);
		m1.parse();
		metier.addMessage(m1);
		Message m2 = new Message("Je m'ennui mais #pasamort #jenaimarre",u2);
		m2.parse();
		metier.addMessage(m2);
		Message m3 = new Message("@Mohcine @farid Dernier test avec #ennui pour double ",u3);
		m3.parse();
		metier.addMessage(m3);
		
		
		
		
		Utilisateur util = new Utilisateur("yroyro", "yahia", "benali");
		Utilisateur util2 = new Utilisateur("scof", "Mohcine", "boujibar");
		metier.addUser(util);
		metier.addUser(util2);
		
		
	}

}
