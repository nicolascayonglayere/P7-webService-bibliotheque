package OC.webService.nicolas.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import OC.webService.nicolas.business.contract.LivreManager;
import OC.webService.nicolas.model.entites.Auteur;
import OC.webService.nicolas.model.entites.Livre;

/**
 * Implémentation de {@link LivreManager}
 * 
 * @author nicolas
 *
 */
@Component
public class LivreManagerImpl extends AbstractManager implements LivreManager {

	static final Logger logger = LogManager.getLogger();
	private List<Livre> livres = new ArrayList<Livre>();

	/**
	 * Méthode pour obtenir les 6 derniers {@link Livre} inscrits en bdd
	 */
	@Override
	public List<Livre> obtenirNouveautes() {

		List<Livre> livresBiblio = this.getDaoFactory().getLivreDao().findAll();
		for (int i = livresBiblio.size(); i == (livresBiblio.size()) - 6; i--) {
			this.livres.add(livresBiblio.get(i));
		}

		return this.livres;
	}

	/**
	 * Méthode pour trouver un {@link Livre} à partir de son titre et du nom de son
	 * {@link Auteur} donné en paramètres
	 */
	@Override
	public List<Livre> trouverParTitreEtAuteur(String pTitre, String pNom) throws RuntimeException {
		logger.debug(pTitre + pNom);
		if (this.getDaoFactory().getLivreDao().findByTitreAndAuteurs(pTitre, pNom).size() > 0) {
			this.livres = this.getDaoFactory().getLivreDao().findByTitreAndAuteurs(pTitre, pNom);
		} else {
			throw new RuntimeException("ouvrage non trouvé : titre = " + pTitre + " - auteur = " + pNom);
		}

		return this.livres;
	}

}
