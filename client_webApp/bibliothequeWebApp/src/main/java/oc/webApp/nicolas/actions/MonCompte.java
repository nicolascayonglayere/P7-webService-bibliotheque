package oc.webApp.nicolas.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import fr.yogj.bibliows.BiblioWS_Service;
import fr.yogj.bibliows.ObtenirEmpruntUtilisateurFault_Exception;
import fr.yogj.bibliows.types.CoordonneeUtilisateurType;
import fr.yogj.bibliows.types.LivreEmpruntType;
import fr.yogj.bibliows.types.UtilisateurType;

public class MonCompte extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	static final Logger logger = LogManager.getLogger();
	private BiblioWS_Service biblioWS = new BiblioWS_Service();
	private Map<String, Object> session;
	private UtilisateurType utilisateur = new UtilisateurType();
	private List<LivreEmpruntType> listEmprunt = new ArrayList<LivreEmpruntType>();
	private CoordonneeUtilisateurType coordonneeUtilisateur = new CoordonneeUtilisateurType();

	/**
	 * Méthode retournant les données nécessaires à la jsp affichant le compte d'un
	 * {@link UtilisateurType}
	 */
	@Override
	public String execute() {
		this.utilisateur = ((UtilisateurType) this.session.get("utilisateur"));
		logger.debug("Compte de " + this.utilisateur.getPseudo());
		try {
			this.listEmprunt = this.biblioWS.getBiblioWSSOAP().obtenirEmpruntUtilisateur(this.utilisateur.getId());
			this.coordonneeUtilisateur.setAdresse(this.utilisateur.getCoordonnee().get(0).getAdresse());
			this.coordonneeUtilisateur.setEmail(this.utilisateur.getCoordonnee().get(0).getEmail());
			return ActionSupport.SUCCESS;
		} catch (ObtenirEmpruntUtilisateurFault_Exception e) {
			this.addActionMessage(e.getMessage());
			e.printStackTrace();
			logger.debug(e.getMessage());
			return ActionSupport.INPUT;
		}

	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public UtilisateurType getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(UtilisateurType utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<LivreEmpruntType> getListEmprunt() {
		return this.listEmprunt;
	}

	public void setListEmprunt(List<LivreEmpruntType> listEmprunt) {
		this.listEmprunt = listEmprunt;
	}

	public BiblioWS_Service getBiblioWS() {
		return this.biblioWS;
	}

	public void setBiblioWS(BiblioWS_Service biblioWS) {
		this.biblioWS = biblioWS;
	}

	public CoordonneeUtilisateurType getCoordonneeUtilisateur() {
		return this.coordonneeUtilisateur;
	}

	public void setCoordonneeUtilisateur(CoordonneeUtilisateurType coordonneeUtilisateur) {
		this.coordonneeUtilisateur = coordonneeUtilisateur;
	}

}