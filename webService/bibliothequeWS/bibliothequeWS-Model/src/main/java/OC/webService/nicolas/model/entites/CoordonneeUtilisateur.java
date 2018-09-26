package OC.webService.nicolas.model.entites;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CoordonneeUtilisateur {

	@Id 
	@GeneratedValue 
	@Column(name="id_coordonnee")
	private Integer id;
	@Column(length=100)
	private String adresse;
	@Column(length=60, unique=true)
	private String email;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}) 
	@JoinColumn(name="id_utilisateur")
	private Utilisateur utilisateur;

	public CoordonneeUtilisateur() {}

	public CoordonneeUtilisateur(String adresse, String email, Utilisateur utilisateur) {
		this.adresse = adresse;
		this.email = email;
		this.utilisateur = utilisateur;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
}
