package oc.webApp.nicolas.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionSupport;

import fr.yogj.bibliows.BiblioWS_Service;
import fr.yogj.bibliows.ObtenirEmpruntUtilisateurFault_Exception;
import fr.yogj.bibliows.types.LivreEmpruntType;
import fr.yogj.bibliows.types.UtilisateurType;

@Service
public class BilanEmpruntAjax extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	private BiblioWS_Service biblioWS = new BiblioWS_Service();
	private List<LivreEmpruntType> listEmprunts = new ArrayList<LivreEmpruntType>();
	private Map<String, Object> session;

	@Override
	public String execute() {

		try {
			this.listEmprunts = this.biblioWS.getBiblioWSSOAP()
					.obtenirEmpruntUtilisateur((((UtilisateurType) this.session.get("utilisateur")).getId()));
		} catch (ObtenirEmpruntUtilisateurFault_Exception e) {
			this.addActionMessage(e.getMessage());
			e.printStackTrace();
			return ActionSupport.INPUT;
		}
		return ActionSupport.SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<LivreEmpruntType> getListEmprunts() {
		return this.listEmprunts;
	}

	public void setListEmprunts(List<LivreEmpruntType> listEmprunts) {
		this.listEmprunts = listEmprunts;
	}
}
