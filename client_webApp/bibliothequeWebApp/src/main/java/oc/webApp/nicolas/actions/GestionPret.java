package oc.webApp.nicolas.actions;

import java.util.Map;

import javax.xml.ws.soap.SOAPFaultException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionSupport;

import fr.yogj.bibliows.BiblioWS_Service;
import fr.yogj.bibliows.EmpruntOuvrageFault_Exception;
import fr.yogj.bibliows.ProlongationOuvrageFault1_Exception;
import fr.yogj.bibliows.RetourOuvrageFault1_Exception;
import fr.yogj.bibliows.types.LivreEmpruntType;
import fr.yogj.bibliows.types.LivreType;
import fr.yogj.bibliows.types.UtilisateurType;

/**
 * Classe action qui gère les {@link LivreEmpruntType}
 * 
 * @author nicolas
 *
 */
@Service
public class GestionPret extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	static final Logger logger = LogManager.getLogger();
	private BiblioWS_Service biblioWS = new BiblioWS_Service();
	private String idLivre;
	private String idEmprunt;
	private LivreType livreType;// = new LivreType();
	private UtilisateurType utilisateur;// = new UtilisateurType();
	private LivreEmpruntType monEmprunt;// = new LivreEmpruntType();
	private Map<String, Object> session;

	/**
	 * Méthode pour emprunter un livre
	 * 
	 * @return
	 */
	public String emprunter() {

		this.utilisateur = ((UtilisateurType) this.session.get("utilisateur"));
		logger.debug("emprunt : " + this.idLivre + " - user :" + this.utilisateur.getPseudo());
		System.out.println("emprunt : " + this.idLivre + " - user :" + this.utilisateur.getPseudo());
		try {
			this.monEmprunt = this.biblioWS.getBiblioWSSOAP().empruntOuvrage(Integer.valueOf(this.idLivre),
					this.utilisateur.getId());
			this.addActionMessage("Votre emprunt a été enregistré avc le n° : " + this.monEmprunt.getId());
			return ActionSupport.SUCCESS;
		} catch (EmpruntOuvrageFault_Exception e) {
			logger.debug(e.getMessage());
			this.addActionMessage(e.getMessage());
			e.printStackTrace();
			return ActionSupport.INPUT;
		} catch (SOAPFaultException e1) {
			logger.debug(e1.getMessage());
			this.addActionMessage(e1.getMessage());
			e1.printStackTrace();
			return ActionSupport.INPUT;
		}

	}

	/**
	 * Méthode pour rendre un livre
	 * 
	 * @return
	 */
	public String retourner() {

		this.utilisateur = (UtilisateurType) this.session.get("utilisateur");
		// logger.debug("nom ouvrage retourner " +
		// this.monEmprunt.getOuvrage().getTitre() + " nom emprunteur "+
		// this.utilisateur.getPseudo());
		try {
			this.livreType = this.biblioWS.getBiblioWSSOAP().retourOuvrage(Integer.valueOf(this.idEmprunt));
			this.addActionMessage("Vous avez rendu le livre : " + this.livreType.getTitre());
			return ActionSupport.SUCCESS;
		} catch (RetourOuvrageFault1_Exception e) {
			logger.debug(e.getMessage());
			this.addActionMessage(e.getMessage());
			e.printStackTrace();
			return ActionSupport.INPUT;
		}

	}

	/**
	 * Méthode pour prolonger le pret d'un livre
	 * 
	 * @return
	 */
	public String prolonger() {

		this.utilisateur = (UtilisateurType) this.session.get("utilisateur");
		// logger.debug("nom ouvrage retourner " +
		// this.monEmprunt.getOuvrage().getTitre() + " nom emprunteur "+
		// this.utilisateur.getPseudo());
		try {
			this.monEmprunt = this.biblioWS.getBiblioWSSOAP().prolongationOuvrage(Integer.valueOf(this.idEmprunt));
			this.addActionMessage("Vous avez prolongé l'emprunt n° : " + this.idEmprunt);
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

	public String getIdLivre() {
		return this.idLivre;
	}

	public void setIdLivre(String idLivre) {
		this.idLivre = idLivre;
	}

	public String getIdEmprunt() {
		return this.idEmprunt;
	}

	public void setIdEmprunt(String idEmprunt) {
		this.idEmprunt = idEmprunt;
	}

}
