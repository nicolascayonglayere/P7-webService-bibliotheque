package oc.webApp.nicolas.actions;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import fr.yogj.bibliows.BiblioWS_Service;
import fr.yogj.bibliows.EmpruntOuvrageFault_Exception;
import fr.yogj.bibliows.ProlongationOuvrageFault1_Exception;
import fr.yogj.bibliows.RetourOuvrageFault1_Exception;
import fr.yogj.bibliows.types.LivreEmpruntType;
import fr.yogj.bibliows.types.LivreType;
import fr.yogj.bibliows.types.UtilisateurType;

public class GestionPret extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	static final Logger logger = LogManager.getLogger();
	private BiblioWS_Service biblioWS = new BiblioWS_Service();
	private LivreType livreType = new LivreType();
	private UtilisateurType utilisateur = new UtilisateurType();
	private LivreEmpruntType monEmprunt = new LivreEmpruntType();
	private Map<String, Object> session;

	public String emprunter() {
		logger.debug("emprunt : " + this.livreType.getTitre());
		this.utilisateur = ((UtilisateurType) this.session.get("utilisateur"));

		try {
			this.monEmprunt = this.biblioWS.getBiblioWSSOAP().empruntOuvrage(this.livreType.getId(),
					this.utilisateur.getId());
			this.addActionMessage("Votre emprunt a été enregistré avc le n° : " + this.monEmprunt.getId());
			return ActionSupport.SUCCESS;
		} catch (EmpruntOuvrageFault_Exception e) {
			logger.debug(e.getMessage());
			this.addActionMessage(e.getMessage());
			e.printStackTrace();
			return ActionSupport.INPUT;
		}

	}

	public String retourner() {
		logger.debug("nom ouvrage retourner " + this.monEmprunt.getOuvrage().getTitre() + " nom emprunteur "
				+ this.utilisateur.getPseudo());
		this.utilisateur = (UtilisateurType) this.session.get("utilisateur");

		try {
			this.livreType = this.biblioWS.getBiblioWSSOAP().retourOuvrage(this.monEmprunt.getId());
			this.addActionMessage("Vous avez rendu le livre : " + this.livreType.getTitre());
			return ActionSupport.SUCCESS;
		} catch (RetourOuvrageFault1_Exception e) {
			logger.debug(e.getMessage());
			this.addActionMessage(e.getMessage());
			e.printStackTrace();
			return ActionSupport.INPUT;
		}

	}

	public String prolonger() {
		logger.debug("nom ouvrage retourner " + this.monEmprunt.getOuvrage().getTitre() + " nom emprunteur "
				+ this.utilisateur.getPseudo());
		this.utilisateur = (UtilisateurType) this.session.get("utilisateur");

		try {
			this.monEmprunt = this.biblioWS.getBiblioWSSOAP().prolongationOuvrage(this.monEmprunt.getId());
			this.addActionMessage("Vous avez prolongé l'emprunt n° : " + this.monEmprunt.getId());
			return ActionSupport.SUCCESS;
		} catch (ProlongationOuvrageFault1_Exception e) {
			logger.debug(e.getMessage());
			this.addActionMessage(e.getMessage());
			e.printStackTrace();
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

	public LivreEmpruntType getMonEmprunt() {
		return this.monEmprunt;
	}

	public void setMonEmprunt(LivreEmpruntType monEmprunt) {
		this.monEmprunt = monEmprunt;
	}

}
