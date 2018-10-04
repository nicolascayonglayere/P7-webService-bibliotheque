package OC.webService.nicolas.business.contract;


import java.util.List;

import OC.webService.nicolas.model.entites.Livre;

public interface LivreManager   {

	public List<Livre> obtenirNouveautes();
	
	public List<Livre> trouverParTitreEtAuteur(String pTitre, String pNom);



}
