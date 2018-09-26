package OC.webService.nicolas.model.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Editeur {

	@Id
	@GeneratedValue
	@Column(name="id_editeur")
	private Integer id;
	@Column(length=60, unique=true)
	private String nom;
	@Column(length=60)
	private String adresse;
	@ManyToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinTable(name="livre_edition", 
				joinColumns=@JoinColumn(name="id_editeur"),
				inverseJoinColumns=@JoinColumn(name="id_livre"))
	private List<Livre> livreEdites;
	
	public Editeur() {}

	public Editeur(String nom, String adresse) {
		this.nom = nom;
		this.adresse = adresse;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public List<Livre> getLivreEdites() {
		return livreEdites;
	}

	public void setLivreEdites(List<Livre> livreEdites) {
		this.livreEdites = livreEdites;
	}
	
	public void addLivresEdites(Livre pLivre) {
		if(this.livreEdites == null) {
			this.livreEdites = new ArrayList<Livre>();
		}
		this.livreEdites.add(pLivre);
		pLivre.addEditeurs(this);
	}
	
	
}
