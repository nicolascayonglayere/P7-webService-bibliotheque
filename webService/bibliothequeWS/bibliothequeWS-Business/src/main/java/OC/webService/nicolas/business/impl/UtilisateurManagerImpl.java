package OC.webService.nicolas.business.impl;

import org.springframework.stereotype.Component;

import OC.webService.nicolas.business.contract.UtilisateurManager;
import OC.webService.nicolas.model.entites.Utilisateur;

@Component
public class UtilisateurManagerImpl extends AbstractManager implements UtilisateurManager {

	@Override
	public Utilisateur getUtilisateur(String pseudo, String motDePasse) {
		Utilisateur user = getDaoFactory().getUtilisateurDao().findByPseudoAndMotDePasse(pseudo, motDePasse);
		return user;
	}

}
