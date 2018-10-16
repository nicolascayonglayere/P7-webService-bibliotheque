package oc.webApp.nicolas.actions;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

import fr.yogj.bibliows.BiblioWS_Service;
import fr.yogj.bibliows.DetailsOuvrageFault_Exception;
import fr.yogj.bibliows.RechercheOuvrage;
import fr.yogj.bibliows.types.LivreType;

/**
 * Classe Action RechercheMultiCritere qui permet de rechercher un livre
 * 
 * @author nicolas
 *
 */
public class RechercheMultiCritere extends ActionSupport {

	private static final long serialVersionUID = 1L;
	static final Logger logger = LogManager.getLogger();
	private BiblioWS_Service biblioWS = new BiblioWS_Service();
	private String titre;
	private String nomAuteur;
	private String selectedGenre;
	private List<LivreType> listResultat = new ArrayList<LivreType>();

	/**
	 * Méthode qui construit et envoie les donnees a la jsp
	 * 
	 * @return
	 */
	public String exectue() {
		logger.debug("recherche multi : titre = " + this.titre + " - auteur = " + this.nomAuteur + " - genre = "
				+ this.selectedGenre);
		RechercheOuvrage parameters = new RechercheOuvrage();
		if (this.titre.length() > 0) {
			parameters.setTitre(this.titre);
		}
		if (this.selectedGenre.length() > 0) {
			parameters.setGenre(this.selectedGenre);
		}
		if (this.nomAuteur.length() > 0) {
			parameters.setAuteurNom(this.nomAuteur);
		}
		try {
			this.listResultat = this.biblioWS.getBiblioWSSOAP().rechercheOuvrage(parameters).getOuvrages();
		} catch (DetailsOuvrageFault_Exception e) {
			logger.debug(e.getMessage());
			this.addActionMessage(e.getMessage());
			e.printStackTrace();
			return ActionSupport.INPUT;
		}
		return ActionSupport.SUCCESS;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getNomAuteur() {
		return this.nomAuteur;
	}

	public void setNomAuteur(String nomAuteur) {
		this.nomAuteur = nomAuteur;
	}

	public String getSelectedGenre() {
		return this.selectedGenre;
	}

	public void setSelectedGenre(String selectedGenre) {
		this.selectedGenre = selectedGenre;
	}

	public List<LivreType> getListResultat() {
		return this.listResultat;
	}

	public void setListResultat(List<LivreType> listResultat) {
		this.listResultat = listResultat;
	}

}
