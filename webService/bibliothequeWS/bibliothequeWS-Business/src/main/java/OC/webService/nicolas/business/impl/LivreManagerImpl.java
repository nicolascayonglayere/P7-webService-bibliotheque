package OC.webService.nicolas.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import OC.webService.nicolas.business.contract.LivreManager;
import OC.webService.nicolas.model.entites.Livre;

@Component
public class LivreManagerImpl extends AbstractManager implements LivreManager {

	static final Logger logger = LogManager.getLogger();
	private List<Livre> livres = new ArrayList<Livre>();

	@Override
	public List<Livre> obtenirNouveautes() {

		List<Livre> livresBiblio = this.getDaoFactory().getLivreDao().findAll();
		for (int i = livresBiblio.size(); i == (livresBiblio.size()) - 6; i--) {
			this.livres.add(livresBiblio.get(i));
		}

		return this.livres;
	}

	@Override
	public List<Livre> trouverParTitreEtAuteur(String pTitre, String pNom) throws RuntimeException {
		logger.debug(pTitre + pNom);
		if (this.getDaoFactory().getLivreDao().findByTitreAndAuteurs(pTitre, pNom).size() > 0) {
			this.livres = this.getDaoFactory().getLivreDao().findByTitreAndAuteurs(pTitre, pNom);
			for (Livre l : this.livres) {
				int nbEx = this.getDaoFactory().getLivreEmpruntDao().findByLivreId(l.getId()).size();
				l.setNbExemplaire(l.getNbExemplaire() - nbEx);// verifier la difference
			}
		} else {
			throw new RuntimeException("ouvrage non trouvé : titre = " + pTitre + " - auteur = " + pNom);
		}

		return this.livres;
	}

}
