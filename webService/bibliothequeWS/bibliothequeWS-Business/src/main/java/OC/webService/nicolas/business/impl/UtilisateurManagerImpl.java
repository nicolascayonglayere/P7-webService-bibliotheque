package OC.webService.nicolas.business.impl;

import java.util.Optional;

import org.springframework.stereotype.Component;

import OC.webService.nicolas.business.contract.UtilisateurManager;
import OC.webService.nicolas.model.entites.Utilisateur;

@Component
public class UtilisateurManagerImpl extends AbstractManager implements UtilisateurManager {

	private Utilisateur user = new Utilisateur();

	@Override
	public Utilisateur getUtilisateur(String pseudo, String motDePasse) throws RuntimeException {
		if (this.getDaoFactory().getUtilisateurDao().findByPseudoAndMotDePasse(pseudo, motDePasse).getId() != 0) {
			this.user = this.getDaoFactory().getUtilisateurDao().findByPseudoAndMotDePasse(pseudo, motDePasse);
			return this.user;
		} else {
			throw new RuntimeException("Identifiants invalides pseudo : " + pseudo + " - mot de passe : " + motDePasse);
		}

	}

	@Override
	public Utilisateur getUtilisateur(int id) throws RuntimeException {
		Optional<Utilisateur> myOptional = this.getDaoFactory().getUtilisateurDao().findById(id);
		this.user = myOptional.get();
		if (this.user.getId() == 0) {
			throw new RuntimeException("Utilisateur non trouvé " + id);
		} else
			return this.user;
	}

	// public Utilisateur getUser() {
	// return user;
	// }
	//
	// @Autowired
	// public void setUser(Utilisateur user) {
	// this.user = user;
	// }

}
