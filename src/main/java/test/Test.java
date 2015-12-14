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
		User u1 = new User("farid59","aouragh","farid", "test@test.fr", 0654453432L);
		User u2 = new User("yroyro", "benali","yahia","yah.ben@ben.com", 0654657634L);
		User u3 = new User("scof", "boujibar","Mohcine","test@test.fr", 0654657634L);
		User u4 = new User("nico","Noullez","Nicolas", "Noullez@gmail.fr", 0654657634L);
		metier.addClient(u1);
		metier.addClient(u2);
		metier.addClient(u3);
		metier.addClient(u4);
		Message m1 = new Message("coucou @farid59 #ennui",u1);
		m1.parse();
		metier.addMessage(m1);
		Message m2 = new Message("Je m'ennui mais #pasamort #jenaimarre",u2);
		m2.parse();
		metier.addMessage(m2);
		Message m3 = new Message("@scof @farid59 Dernier test avec #ennui pour double ",u3);
		m3.parse();
		metier.addMessage(m3);
		Message m4 = new Message("@scof @farid59 encore un pour la route #rienafaire ",u4);
		m4.parse();
		metier.addMessage(m4);
		
		Message m5 = new Message("Trop de travail n'est-ce pas @yroyro",u1);
		m5.parse();
		metier.addMessage(m5);
		Message m6 = new Message("@nico le projet est trop hard #jenaimarre",u2);
		m6.parse();
		metier.addMessage(m6);
		Message m7 = new Message("@scof @farid59 Dernier test avec de dormir #fatigue ",u3);
		m7.parse();
		metier.addMessage(m7);
		Message m8 = new Message("@scof @farid59 @yroyro #bonnenuit ",u4);
		m8.parse();
		metier.addMessage(m8);
		
	}

}
