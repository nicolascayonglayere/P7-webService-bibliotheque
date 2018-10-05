package OC.webService.nicolas.business.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import OC.webService.nicolas.business.contract.UtilisateurManager;
import OC.webService.nicolas.model.entites.Utilisateur;

@Transactional
@Component
public class UtilisateurManagerImpl extends AbstractManager implements UtilisateurManager {
	
	private Utilisateur user = new Utilisateur();

	@Transactional
	@Override
	public Utilisateur getUtilisateur(String pseudo, String motDePasse) throws RuntimeException{
		if (this.getDaoFactory().getUtilisateurDao().findByPseudoAndMotDePasse(pseudo, motDePasse).getId() !=0) {
			user = getDaoFactory().getUtilisateurDao().findByPseudoAndMotDePasse(pseudo, motDePasse);
			return user;
		}
		else {
			throw new RuntimeException ("Identifiants invalides pseudo : "+pseudo+" - mot de passe : "+motDePasse);
		}

		
	}

	@Transactional
	@Override
	public Utilisateur getUtilisateur(int id) throws RuntimeException{
		Optional<Utilisateur> myOptional = getDaoFactory().getUtilisateurDao().findById(id);
		user = myOptional.get();
		if(user.getId() == 0) {
			throw new RuntimeException("Utilisateur non trouvé "+id);
		}
		else
			return user;
	}

	//public Utilisateur getUser() {
	//	return user;
	//}
    //
	//@Autowired
	//public void setUser(Utilisateur user) {
	//	this.user = user;
	//}
	
	

}
