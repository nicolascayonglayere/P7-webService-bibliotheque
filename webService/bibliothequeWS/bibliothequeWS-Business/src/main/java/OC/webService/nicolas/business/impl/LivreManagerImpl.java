package OC.webService.nicolas.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import OC.webService.nicolas.business.contract.LivreManager;
import OC.webService.nicolas.model.entites.Livre;

@Component
public class LivreManagerImpl extends AbstractManager implements LivreManager {


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
	public Livre trouverParTitreEtAuteur(String pTitre, String pNom) {
		Livre livre = getDaoFactory().getLivreDao().findByTitreAndAuteurs(pTitre, pNom);
		int nbEx = getDaoFactory().getLivreEmpruntDao().findByLivreId(livre.getId()).size();
		livre.setNbExemplaire(livre.getNbExemplaire() - nbEx);//verifier la difference
		return livre;
	}

}
