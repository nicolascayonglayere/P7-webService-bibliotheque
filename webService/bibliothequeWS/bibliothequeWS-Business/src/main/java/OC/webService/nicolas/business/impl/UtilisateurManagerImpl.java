package OC.webService.nicolas.business.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import OC.webService.nicolas.business.contract.UtilisateurManager;
import OC.webService.nicolas.business.mapper.MapperUtilisateur;
import OC.webService.nicolas.model.entites.Utilisateur;
import fr.yogj.bibliows.types.UtilisateurType;

/**
 * Implémentation de {@link UtilisateurManager}
 * 
 * @author nicolas
 *
 */
@Transactional
@Component
public class UtilisateurManagerImpl extends AbstractManager implements UtilisateurManager {

	private Utilisateur user = new Utilisateur();

	/**
	 * Méthode pour obtenir l {@link Utilisateur} à partir de son pseudo et de son
	 * mot de passe donnés en paramètre
	 */
	@Override
	public UtilisateurType getUtilisateur(String pseudo, String motDePasse) throws RuntimeException {
		if (this.getDaoFactory().getUtilisateurDao().findByPseudoAndMotDePasse(pseudo, motDePasse).getId() != 0) {
			this.user = this.getDaoFactory().getUtilisateurDao().findByPseudoAndMotDePasse(pseudo, motDePasse);
			// this.user.setEmprunts(this.getDaoFactory().getLivreEmpruntDao().findByUtilisateurId(this.user.getId()));
			return MapperUtilisateur.fromUtilisateurToUtilisateurType(this.user);
		} else {
			throw new RuntimeException("Identifiants invalides pseudo : " + pseudo + " - mot de passe : " + motDePasse);
		}

	}

	/**
	 * Méthode pour obtenir un{@link Utilisateur} à partir de son id donné en
	 * paramètre
	 */
	@Override
	public UtilisateurType getUtilisateur(int id) throws RuntimeException {
		Optional<Utilisateur> myOptional = this.getDaoFactory().getUtilisateurDao().findById(id);
		this.user = myOptional.get();
		if (this.user.getId() == 0) {
			throw new RuntimeException("Utilisateur non trouvé " + id);
		} else
			return MapperUtilisateur.fromUtilisateurToUtilisateurType(this.user);
	}
}
