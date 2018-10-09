package OC.webService.nicolas.model.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "utilisateur")
public class Utilisateur implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "id_utilisateur")
	private Integer id;
	@Column(length = 60)
	private String nom;
	@Column(length = 60)
	private String prenom;
	@Column(length = 60, unique = true)
	private String pseudo;
	@Column(name = "mot_de_passe", length = 100)
	private String motDePasse;
	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@Fetch(value = FetchMode.SUBSELECT)
	private List<CoordonneeUtilisateur> coordonnee;
	@OneToMany(mappedBy = "utilisateur", cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH })
	@Fetch(value = FetchMode.SUBSELECT)
	private List<LivreEmprunt> emprunts;

	public Utilisateur() {
	}

	public Utilisateur(String nom, String prenom, String pseudo, String motDePasse) {
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
		this.motDePasse = motDePasse;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPseudo() {
		return this.pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMotDePasse() {
		return this.motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public List<CoordonneeUtilisateur> getCoordonnee() {
		return this.coordonnee;
	}

	public void setCoordonnee(List<CoordonneeUtilisateur> coordonnee) {
		this.coordonnee = coordonnee;
	}

	public void addCoordonnee(CoordonneeUtilisateur pCoordonnee) {
		if (this.coordonnee == null) {
			this.coordonnee = new ArrayList<CoordonneeUtilisateur>();
		}

		this.coordonnee.add(pCoordonnee);
		pCoordonnee.setUtilisateur(this);
	}

	public List<LivreEmprunt> getEmprunts() {
		return this.emprunts;
	}

	public void setEmprunts(List<LivreEmprunt> emprunts) {
		this.emprunts = emprunts;
	}

	public void addEmprunts(LivreEmprunt pLivreEmprunt) {
		if (this.emprunts == null) {
			this.emprunts = new ArrayList<LivreEmprunt>();
		}
		this.emprunts.add(pLivreEmprunt);
		pLivreEmprunt.setUtilisateur(this);
	}
}
