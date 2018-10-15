package oc.webApp.nicolas.actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

import fr.yogj.bibliows.BiblioWS_Service;
import fr.yogj.bibliows.DetailsOuvrageFault_Exception;
import fr.yogj.bibliows.RechercheOuvrage;
import fr.yogj.bibliows.RechercheOuvrageResponse;
import fr.yogj.bibliows.types.LivreType;

public class GoLivre extends ActionSupport {

	private static final long serialVersionUID = 1L;
	static final Logger logger = LogManager.getLogger();
	private BiblioWS_Service biblioWS = new BiblioWS_Service();
	private LivreType livreType = new LivreType();

	@Override
	public String execute() {
		RechercheOuvrage param = new RechercheOuvrage();
		if (this.livreType.getId() != 0) {
			// param.setId(livreType.getId();
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
}