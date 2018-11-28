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
	/// private static String url_ws;
	private List<LivreType> livresAccueil = new ArrayList<LivreType>();
	// private EmplacementWS ws = new EmplacementWS();

	// private BiblioWS biblioWS;

	/**
	 * Méthode qui construit et envoie les données nécessaires à la jsp
	 */
	@Override
	public String execute() {
		// URL url = new URL(url_ws);
		BiblioWS_Service biblioWS = new BiblioWS_Service();// this.ws.getMonUrl());
		ListNouveautesResponse lnr = biblioWS.getBiblioWSSOAP().listNouveautes("");

		this.livresAccueil = lnr.getNouveautes();

		return ActionSupport.SUCCESS;
	}

	public List<LivreType> getLivresAccueil() {
		return this.livresAccueil;
	}

	public void setLivresAccueil(List<LivreType> livresAccueil) {
		this.livresAccueil = livresAccueil;
	}

	// public static String getUrl_ws() {
	// return url_ws;
	// }
	// @Value("${biblio.ws.endpoint.url}")
	// public static void setUrl_ws(String url_ws) {
	// Accueil.url_ws = url_ws;
	// }
} //
