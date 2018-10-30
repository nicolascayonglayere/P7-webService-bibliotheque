package oc.webApp.nicolas.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.soap.SOAPFaultException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionSupport;

import fr.yogj.bibliows.BiblioWS_Service;
import fr.yogj.bibliows.Deconnexion;
import fr.yogj.bibliows.DeconnexionFault_Exception;
import fr.yogj.bibliows.LoginFault_Exception;
import fr.yogj.bibliows.types.UtilisateurType;

/**
 * Classe Action Login qui gère la connexion et la deconnexion d'un
 * {@link UtilisateurType}
 * 
 * @author nicolas
 *
 */
@Service
public class Login extends ActionSupport implements SessionAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	static final Logger logger = LogManager.getLogger();
	private HttpServletRequest servletRequest;
	private Map<String, Object> session;
	private UtilisateurType utilisateur;// = new UtilisateurType();
	private BiblioWS_Service biblioWS = new BiblioWS_Service();

	/**
	 * Méthode pour déconnecter un {@link UtilisateurType}
	 * 
	 * @return
	 */
	public String logOut() {
		int userId = ((UtilisateurType) this.session.get("utilisateur")).getId();
		Deconnexion deco = new Deconnexion();
		deco.setId(userId);
		logger.debug("deco - " + userId);
		try {
			this.biblioWS.getBiblioWSSOAP().deconnexion(deco);
		} catch (DeconnexionFault_Exception e) {
			this.addActionMessage(e.getMessage());
			e.printStackTrace();
			logger.debug(e.getMessage());
			return ActionSupport.INPUT;
		}
		this.session.remove("utilisateur");
		this.servletRequest.getSession().invalidate();
		this.addActionMessage("You Have Been Successfully Logged Out");
		return ActionSupport.SUCCESS;
	}

	/**
	 * Méthode pour connecter un {@link UtilisateurType}
	 * 
	 * @return
	 */
	public String loginRegisterUser() {
		String vResult = "";
		logger.debug(this.utilisateur.getPseudo() + " - " + this.utilisateur.getMotDePasse());
		UtilisateurType vUser;
		try {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			System.out.println("mdp yogj : " + passwordEncoder.encode(this.utilisateur.getMotDePasse()));
			vUser = this.biblioWS.getBiblioWSSOAP().login(this.utilisateur.getPseudo());
			// passwordEncoder.encode(this.utilisateur.getMotDePasse()));
			logger.debug("mdp : " + vUser.getMotDePasse());

			if ((this.utilisateur.getPseudo().equals(vUser.getPseudo()))
					&& (passwordEncoder.matches(this.utilisateur.getMotDePasse(), vUser.getMotDePasse()))) { // --avec
																												// cryptage
				this.session.put("utilisateur", vUser);
				vResult = ActionSupport.SUCCESS;
			} else {
				this.addActionError("Mot de passe invalide");
				vResult = ActionSupport.LOGIN;
			}

		} catch (LoginFault_Exception e) {
			this.addActionMessage(e.getMessage());
			e.printStackTrace();
			logger.debug(e.getMessage());
			vResult = ActionSupport.LOGIN;
		} catch (SOAPFaultException e) {
			this.addActionMessage(e.getMessage());
			e.printStackTrace();
			logger.debug(e.getMessage());
			vResult = ActionSupport.LOGIN;
		}

		return vResult;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.servletRequest = request;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public UtilisateurType getUtilisateur() {
		return this.utilisateur;
	}

	// @Autowired
	public void setUtilisateur(UtilisateurType utilisateur) {
		this.utilisateur = utilisateur;
	}

	public BiblioWS_Service getBiblioWS() {
		return this.biblioWS;
	}

	// @Autowired
	public void setBiblioWS(BiblioWS_Service biblioWS) {
		this.biblioWS = biblioWS;
	}

}
