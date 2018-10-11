package oc.webApp.nicolas.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import fr.yogj.bibliows.BiblioWS_Service;
import fr.yogj.bibliows.ListNouveautesResponse;
import fr.yogj.bibliows.types.LivreType;

public class Accueil extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private List<LivreType> livresAccueil;
	private BiblioWS_Service biblioWS = new BiblioWS_Service();

	@Override
	public String execute() {

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
}
