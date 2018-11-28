package oc.webApp.nicolas.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionSupport;

import fr.yogj.bibliows.BiblioWS_Service;
import fr.yogj.bibliows.Deconnexion;
import fr.yogj.bibliows.DeconnexionFault_Exception;
import fr.yogj.bibliows.types.UtilisateurType;

@Service
public class Logout extends ActionSupport implements SessionAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	static final Logger logger = LogManager.getLogger();
	private HttpServletRequest servletRequest;
	private Map<String, Object> session;
	private BiblioWS_Service biblioWS = new BiblioWS_Service();

	/**
	 * Méthode pour déconnecter un {@link UtilisateurType}
	 * 
	 * @return le resultat de l'action
	 */
	public String logOut() {
		int userId = ((UtilisateurType) this.session.get("utilisateur")).getId();
		Deconnexion deco = new Deconnexion();
		deco.setId(userId);
		System.out.println("deco - " + userId);
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

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.servletRequest = request;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

}
