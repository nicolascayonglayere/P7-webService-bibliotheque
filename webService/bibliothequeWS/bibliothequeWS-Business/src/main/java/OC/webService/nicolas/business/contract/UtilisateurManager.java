package OC.webService.nicolas.business.contract;

import OC.webService.nicolas.model.entites.Utilisateur;

/**
 * Interface UtilisateurManager et ses méthodes de traitement
 * 
 * @author nicolas
 *
 */
public interface UtilisateurManager {

	/**
	 * Méthode pour trouver un {@link Utilisateur} à partir de son pseudo et de son
	 * mot de passe donné en paramètre
	 * 
	 * @param pseudo
	 * @param motDePasse
	 * @return {@link Utilisateur}
	 * @throws RuntimeException
	 */
	public Utilisateur getUtilisateur(String pseudo, String motDePasse) throws RuntimeException;

	/**
	 * Méthode pour obtenir l {@link Utilisateur} d'id donné en paramètre
	 * 
	 * @param id
	 * @return {@link Utilisateur}
	 * @throws RuntimeException
	 */
	public Utilisateur getUtilisateur(int id) throws RuntimeException;
}
