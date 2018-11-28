package oc.webApp.nicolas.actions;

import java.util.Map;

import javax.xml.ws.soap.SOAPFaultException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

import fr.yogj.bibliows.BiblioWS_Service;
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
public class Login extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	static final Logger logger = LogManager.getLogger();
	private Map<String, Object> session;
	private String pseudo;
	private String motDePasse;
	private BiblioWS_Service biblioWS = new BiblioWS_Service();

	/**
	 * Méthode pour connecter un {@link UtilisateurType}
	 * 
	 * @return le resultat de l'action
	 */
	public String loginRegisterUser() {
		String vResult = "";
		logger.debug(this.pseudo + " - " + this.motDePasse);
		System.out.println(this.pseudo + " - " + this.motDePasse);
		UtilisateurType vUser;
		try {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			vUser = this.biblioWS.getBiblioWSSOAP().login(this.pseudo);
			logger.debug("mdp : " + vUser.getMotDePasse());

			if ((this.pseudo.equals(vUser.getPseudo()))
					&& (passwordEncoder.matches(this.motDePasse, vUser.getMotDePasse()))) {
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
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public BiblioWS_Service getBiblioWS() {
		return this.biblioWS;
	}

	// @Autowired
	public void setBiblioWS(BiblioWS_Service biblioWS) {
		this.biblioWS = biblioWS;
	}

	public String getMotDePasse() {
		return this.motDePasse;
	}

	@RequiredStringValidator(message = "Un mot de passe est requis.")
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getPseudo() {
		return this.pseudo;
	}

	@RequiredStringValidator(message = "Un pseudo est requis.")
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

}
