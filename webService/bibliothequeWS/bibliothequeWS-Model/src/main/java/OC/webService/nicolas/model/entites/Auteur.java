package OC.webService.nicolas.model.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "auteur")
public class Auteur implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "id_auteur")
	private Integer id;
	@Column(length = 60)
	private String nom;
	@Column(length = 60)
	private String prenom;
	@Column(name = "naissance")
	private Date dateNaissance;
	@Column(length = 60)
	private String nationalite;
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH })
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable(name = "livre_manuscrit", joinColumns = @JoinColumn(name = "id_auteur"), inverseJoinColumns = @JoinColumn(name = "id_livre"))
	private List<Livre> manuscrits;

	public Auteur() {
	}

	public Auteur(String nom, String prenom, Date dateNaissance, String nationalite) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.nationalite = nationalite;
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

	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getNationalite() {
		return this.nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public List<Livre> getManuscrits() {
		return this.manuscrits;
	}

	public void setManuscrits(List<Livre> manuscrits) {
		this.manuscrits = manuscrits;
	}

	public void addManuscrits(Livre pManuscrit) {
		if (this.manuscrits == null) {
			this.manuscrits = new ArrayList<Livre>();
		}
		this.manuscrits.add(pManuscrit);
		pManuscrit.addAuteurs(this);
	}

}
