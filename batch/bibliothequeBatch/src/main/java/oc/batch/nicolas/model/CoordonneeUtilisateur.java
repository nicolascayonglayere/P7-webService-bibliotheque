package oc.batch.nicolas.model;

import org.springframework.stereotype.Component;

@Component
public class CoordonneeUtilisateur {

	private int id;
	private String adresse;
	private String email;
	private Utilisateur utilisateur;

	public CoordonneeUtilisateur() {
	}

	public CoordonneeUtilisateur(int id, String adresse, String email) {
		this.id = id;
		this.adresse = adresse;
		this.email = email;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}
