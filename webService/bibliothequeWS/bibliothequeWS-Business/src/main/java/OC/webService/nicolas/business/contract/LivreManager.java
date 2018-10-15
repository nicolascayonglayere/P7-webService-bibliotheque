package OC.webService.nicolas.business.contract;

import java.util.List;

import OC.webService.nicolas.model.entites.Auteur;
import OC.webService.nicolas.model.entites.Livre;

/**
 * Interface LivreManager et ses méthodes de traitement
 * 
 * @author nicolas
 *
 */
public interface LivreManager {

	/**
	 * Méthode pour avoir la liste des derniers {@link Livre} saisis en base de
	 * donnée
	 * 
	 * @return liste de {@link Livre}
	 */
	public List<Livre> obtenirNouveautes();

	/**
	 * Méthode pour trouver un {@link Livre} à partir de son titre et du nom de son
	 * {@link Auteur} donné en paramètre
	 * 
	 * @param pTitre
	 * @param pNom
	 * @return liste de {@link Livre}
	 * @throws RuntimeException
	 */
	public List<Livre> trouverParTitreEtAuteur(String pTitre, String pNom) throws RuntimeException;

	/**
	 * Méthode pour trouver un {@link Livre} à partir de son id donné en paramètre
	 * 
	 * @param id
	 * @return {@link Livre}
	 */
	public Livre trouverParId(Integer id);

}
