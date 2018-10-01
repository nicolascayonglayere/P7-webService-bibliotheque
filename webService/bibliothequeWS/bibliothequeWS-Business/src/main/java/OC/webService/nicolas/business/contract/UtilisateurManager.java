package OC.webService.nicolas.business.contract;

import OC.webService.nicolas.model.entites.Utilisateur;

public interface UtilisateurManager {

	public Utilisateur getUtilisateur(String pseudo, String motDePasse) ;
	
	public Utilisateur getUtilisateur(int id) throws RuntimeException;
}
