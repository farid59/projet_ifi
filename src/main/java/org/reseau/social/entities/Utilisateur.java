package org.reseau.social.entities;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Utilisateur {
		@Id
		public String userName;
		public String nom;
		public String prenom;
		@ElementCollection
		public Set<String> suscribedHashtags;
		@ElementCollection
		public Set<String> suscribedUsers;
		
		public Utilisateur(String userName, String nom, String prenom) {
			super();
			this.userName = userName;
			this.nom = nom;
			this.prenom = prenom;
		}

		public void suscribeHashtag(String hashtag) {
			if (!this.suscribedHashtags.contains(hashtag)) {
				this.suscribedHashtags.add(hashtag);
			}
		}
		
		public void unsuscribeHashtag(String hashtag) {
			if (this.suscribedHashtags.contains(hashtag)) {
				this.suscribedHashtags.remove(hashtag);
			}
		}
		
		public void suscribeUser(String user) {
			if (!this.suscribedUsers.contains(user)) {
				this.suscribedUsers.add(user);
			}
		}
		
		public void unsuscribeUser(String user) {
			if (this.suscribedUsers.contains(user)) {
				this.suscribedUsers.remove(user);
			}
		}
}
