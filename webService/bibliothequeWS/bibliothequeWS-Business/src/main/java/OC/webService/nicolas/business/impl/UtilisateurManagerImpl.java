package OC.webService.nicolas.business.impl;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import OC.webService.nicolas.business.contract.UtilisateurManager;
import OC.webService.nicolas.model.entites.Utilisateur;

@Transactional
@Component
public class UtilisateurManagerImpl extends AbstractManager implements UtilisateurManager {

	@Override
	public Utilisateur getUtilisateur(String pseudo, String motDePasse) {
		Utilisateur user = getDaoFactory().getUtilisateurDao().findByPseudoAndMotDePasse(pseudo, motDePasse);
		return user;
	}

	@Override
	public Utilisateur getUtilisateur(int id) throws RuntimeException{
		Optional<Utilisateur> myOptional = getDaoFactory().getUtilisateurDao().findById(id);
		Utilisateur user = myOptional.get();
		if(user.getId() == 0) {
			throw new RuntimeException();
		}
		
		return user;
	}
	
	

}
