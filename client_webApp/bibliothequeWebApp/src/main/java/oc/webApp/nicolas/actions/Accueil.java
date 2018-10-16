package oc.webApp.nicolas.actions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionSupport;

import fr.yogj.bibliows.BiblioWS_Service;
import fr.yogj.bibliows.ListNouveautesResponse;
import fr.yogj.bibliows.types.LivreType;

/**
 * Classe Action Accueil peuple la page d'accueil
 * 
 * @author nicolas
 *
 */
@Service
public class Accueil extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private List<LivreType> livresAccueil = new ArrayList<LivreType>();
	private List<String> listGenre = new ArrayList<String>();
	private BiblioWS_Service biblioWS = new BiblioWS_Service();

	/**
	 * Méthode qui construit et envoie les données nécessaires à la jsp
	 */
	@Override
	public String execute() {
		this.listGenre.add("ROMAN");
		this.listGenre.add("SCIENCES-FICTION");
		this.listGenre.add("HEROIC-FANTASY");
		ListNouveautesResponse lnr = this.biblioWS.getBiblioWSSOAP().listNouveautes("");
		this.livresAccueil = lnr.getNouveautes();

		return ActionSupport.SUCCESS;
	}

	public List<LivreType> getLivresAccueil() {
		return this.livresAccueil;
	}

	public void setLivresAccueil(List<LivreType> livresAccueil) {
		this.livresAccueil = livresAccueil;
	}

	public List<String> getListGenre() {
		return this.listGenre;
	}

	public void setListGenre(List<String> listGenre) {
		this.listGenre = listGenre;
	}
}
