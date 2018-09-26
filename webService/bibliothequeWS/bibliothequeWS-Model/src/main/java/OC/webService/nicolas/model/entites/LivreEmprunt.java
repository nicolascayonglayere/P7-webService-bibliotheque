package OC.webService.nicolas.model.entites;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LivreEmprunt {

	@Id 
	@GeneratedValue
	@Column(name="id_emprunt")
	private Integer id;
	@Column(name="date_emprunt")
	private Date dateEmprunt;
	private boolean prolongation;
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}) 
	@JoinColumn(name="id_utilisateur")
	private Utilisateur utilisateur;
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}) 
	@JoinColumn(name="id_livre")
	private Livre livre;

	public LivreEmprunt() {}

	public LivreEmprunt(Date dateEmprunt, boolean prolongation) {
		this.dateEmprunt = dateEmprunt;
		this.prolongation = prolongation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public boolean isProlongation() {
		return prolongation;
	}

	public void setProlongation(boolean prolongation) {
		this.prolongation = prolongation;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}
	
	
	
	
}
