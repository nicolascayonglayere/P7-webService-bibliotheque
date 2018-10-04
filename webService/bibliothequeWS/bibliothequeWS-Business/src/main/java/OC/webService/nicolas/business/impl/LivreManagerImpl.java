package OC.webService.nicolas.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import OC.webService.nicolas.business.contract.LivreManager;
import OC.webService.nicolas.model.entites.Livre;

@Transactional
@Component
public class LivreManagerImpl extends AbstractManager implements LivreManager {

	static final Logger logger = LogManager.getLogger();

	@Override
	public List<Livre> obtenirNouveautes() {

		List<Livre> livresBiblio = getDaoFactory().getLivreDao().findAll();
		List<Livre> nouveautes = new ArrayList<Livre>();

		for (int i=livresBiblio.size(); i==(livresBiblio.size())-6; i--) {
			nouveautes.add(livresBiblio.get(i));
		}

		return nouveautes;
	}

	@Override
	public List<Livre> trouverParTitreEtAuteur(String pTitre, String pNom) {
		logger.debug(pTitre+pNom);
		List<Livre> livres = getDaoFactory().getLivreDao().findByTitreAndAuteurs(pTitre, pNom);
		for (Livre l:livres) {
			int nbEx = getDaoFactory().getLivreEmpruntDao().findByLivreId(l.getId()).size();
			l.setNbExemplaire(l.getNbExemplaire() - nbEx);//verifier la difference
		}
		return livres;
	}

}
