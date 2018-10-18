package oc.webApp.nicolas.actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

import fr.yogj.bibliows.BiblioWS_Service;
import fr.yogj.bibliows.DetailsOuvrageFault_Exception;
import fr.yogj.bibliows.RechercheOuvrage;
import fr.yogj.bibliows.RechercheOuvrageResponse;
import fr.yogj.bibliows.types.LivreType;

/**
 * Classe action qui permet d'afficher la page d'un livre
 * 
 * @author nicolas
 *
 */
public class GoLivre extends ActionSupport {

	private static final long serialVersionUID = 1L;
	static final Logger logger = LogManager.getLogger();
	private BiblioWS_Service biblioWS = new BiblioWS_Service();
	private String idLivre;
	private LivreType livreType = new LivreType();

	/**
	 * Méthode qui construit et envoie les données à la jsp
	 */
	@Override
	public String execute() {
		RechercheOuvrage param = new RechercheOuvrage();
		logger.debug(this.livreType.getId());
		System.out.println(this.idLivre);
		if (Integer.valueOf(this.idLivre) != 0) {
			param.setIdLivre(Integer.valueOf(this.idLivre));
		} else {
			param.setTitre(this.livreType.getTitre());
			param.setGenre(this.livreType.getGenre());
			param.setAuteurNom(this.livreType.getAuteurs().get(0).getNom());
		}

		try {
			RechercheOuvrageResponse rop = this.biblioWS.getBiblioWSSOAP().rechercheOuvrage(param);
			this.livreType = rop.getOuvrages().get(0);
			return ActionSupport.SUCCESS;
		} catch (DetailsOuvrageFault_Exception e) {
			this.addActionMessage(e.getMessage());
			e.printStackTrace();
			logger.debug(e.getMessage());
			return ActionSupport.INPUT;
		}

	}

	public BiblioWS_Service getBiblioWS() {
		return this.biblioWS;
	}

	public void setBiblioWS(BiblioWS_Service biblioWS) {
		this.biblioWS = biblioWS;
	}

	public LivreType getLivreType() {
		return this.livreType;
	}

	public void setLivreType(LivreType livreType) {
		this.livreType = livreType;
	}

	public String getIdLivre() {
		return this.idLivre;
	}

	public void setIdLivre(String idLivre) {
		this.idLivre = idLivre;
	}
}
