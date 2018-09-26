package OC.webService.nicolas.model.entites;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Livre {

	@Id
	@GeneratedValue
	@Column(name="id_livre")
	private Integer id;
	@Column(length=60)
	private String titre;
	private Genre genre;
	@Column(name="date_parution")
	private Date dateParution;
	@Column(name="nb_exemplaire")
	private int nbExemplaire;
	@ManyToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinTable(name="livre_manuscrit", 
				joinColumns=@JoinColumn(name="id_livre"),
				inverseJoinColumns=@JoinColumn(name="id_auteur"))
	private List<Auteur> auteurs;
	@ManyToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinTable(name="livre_edition", 
				joinColumns=@JoinColumn(name="id_livre"),
				inverseJoinColumns=@JoinColumn(name="id_editeur"))	
	private List<Editeur>editeurs;
	@OneToMany(mappedBy="livre", cascade= {CascadeType.ALL})
	private List<LivreEmprunt>emprunts;

	public Livre() {}

	public Livre(String titre, Genre genre, Date dateParution, int nbExemplaire) {
		this.titre = titre;
		this.genre = genre;
		this.dateParution = dateParution;
		this.nbExemplaire = nbExemplaire;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Date getDateParution() {
		return dateParution;
	}

	public void setDateParution(Date dateParution) {
		this.dateParution = dateParution;
	}

	public int getNbExemplaire() {
		return nbExemplaire;
	}

	public void setNbExemplaire(int nbExemplaire) {
		this.nbExemplaire = nbExemplaire;
	}

	public List<LivreEmprunt> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(List<LivreEmprunt> emprunts) {
		this.emprunts = emprunts;
	}
	
	public void addEmprunts(LivreEmprunt pLivreEmprunt) {
		if(this.emprunts == null) {
			this.emprunts = new ArrayList<LivreEmprunt>();
		}
		this.emprunts.add(pLivreEmprunt);
		pLivreEmprunt.setLivre(this);
	}

	public List<Auteur> getAuteurs() {
		return auteurs;
	}

	public void setAuteurs(List<Auteur> auteurs) {
		this.auteurs = auteurs;
	}

	public void addAuteurs(Auteur pAuteur) {
		if(this.auteurs == null) {
			this.auteurs = new ArrayList<Auteur>();
		}
		this.auteurs.add(pAuteur);
		pAuteur.addManuscrits(this);
	}
	
	public List<Editeur> getEditeurs() {
		return editeurs;
	}

	public void setEditeurs(List<Editeur> editeurs) {
		this.editeurs = editeurs;
	}
	
	public void addEditeurs(Editeur pEditeur) {
		if(this.editeurs == null) {
			this.editeurs = new ArrayList<Editeur>();
		}
		this.editeurs.add(pEditeur);
		//pEditeur
	}
	
	
}
