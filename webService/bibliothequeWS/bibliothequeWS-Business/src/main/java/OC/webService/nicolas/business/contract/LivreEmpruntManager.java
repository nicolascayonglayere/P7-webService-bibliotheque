package OC.webService.nicolas.business.contract;

import java.util.List;

import OC.webService.nicolas.model.entites.Livre;
import OC.webService.nicolas.model.entites.LivreEmprunt;
import OC.webService.nicolas.model.entites.Utilisateur;

/**
 * Interface LivreEmpruntManager et ses méthodes de traitement
 * 
 * @author nicolas
 *
 */
public interface LivreEmpruntManager {

	/**
	 * Méthode pour emprunter un {@link Livre} à partir de son id et de l'id de le
	 * {@link Utilisateur}
	 * 
	 * @param pIdLivre
	 * @param pIdEmprunteur
	 * @return {@link LivreEmprunt}
	 * @throws RuntimeException
	 */
	public LivreEmprunt emprunterOuvrage(int pIdLivre, int pIdEmprunteur) throws RuntimeException;

	/**
	 * Méthode pour rendre un {@link Livre} à partir de l'id de {@link LivreEmprunt}
	 * 
	 * @param pIdEmprunt
	 * @return le {@link Livre} rendu
	 * @throws RuntimeException
	 */
	public Livre retournerOuvrage(int pIdEmprunt) throws RuntimeException;

	/**
	 * Méthode pour prolonger un {@link LivreEmprunt} d'id donné en paramètre
	 * 
	 * @param pIdEmprunt
	 * @return le {@link LivreEmprunt} prolongé
	 * @throws RuntimeException
	 */
	public LivreEmprunt prolongerEmprunt(int pIdEmprunt) throws RuntimeException;

	/**
	 * Méthode pour trouver un {@link LivreEmprunt} à partir de son id donné en
	 * paramètre
	 * 
	 * @param pIdEmprunt
	 * @return {@link LivreEmprunt}
	 */
	public LivreEmprunt findByIdEmprunt(int pIdEmprunt);

	/**
	 * Méthode pour obtenir la liste des {@link Utilisateur} en retard
	 * 
	 * @return liste des {@link Utilisateur}
	 */
	public List<Utilisateur> obtenirRetardataires();

	/**
	 * Méthode pour trouver la liste des {@link LivreEmprunt} d'un
	 * {@link Utilisateur} d'id donné en paramètre
	 * 
	 * @param pIdUtilisateur
	 * @return la liste de {@link LivreEmprunt}
	 * @throws RuntimeException
	 */
	public List<LivreEmprunt> obtenirEmpruntUtilisateur(int pIdUtilisateur) throws RuntimeException;
}
