package OC.webService.nicolas.appSpringBoot.helpers;

import OC.webService.nicolas.model.entites.CoordonneeUtilisateur;
import OC.webService.nicolas.model.entites.Utilisateur;
import fr.yogj.bibliows.types.CoordonneeUtilisateurType;
import fr.yogj.bibliows.types.UtilisateurType;

public class MapperUtilisateur {

	public static Utilisateur fromUtilisateurTypeToUtilisateur(UtilisateurType pUtilisateurType) {
		Utilisateur myUser = new Utilisateur (pUtilisateurType.getNom(), pUtilisateurType.getPrenom(), pUtilisateurType.getPseudo(), pUtilisateurType.getMotDePasse());
		myUser.setId(pUtilisateurType.getId());
		for (CoordonneeUtilisateurType cut : pUtilisateurType.getCoordonnee()) {
			myUser.getCoordonnee().add(MapperCoordonneeUtilisateur.frommCoordonneeTypeToCoordonnee(cut));
		}
		
		return myUser;
	}
	
	public static UtilisateurType fromUtilisateurToUtilisateurType(Utilisateur pUtilisateur) {
		UtilisateurType myUt = new UtilisateurType();
		myUt.setId(pUtilisateur.getId());
		myUt.setNom(pUtilisateur.getNom());
		myUt.setPrenom(pUtilisateur.getPrenom());
		myUt.setPseudo(pUtilisateur.getPseudo());
		myUt.setMotDePasse(pUtilisateur.getMotDePasse());
		for (CoordonneeUtilisateur cu : pUtilisateur.getCoordonnee()) {
			myUt.getCoordonnee().add(MapperCoordonneeUtilisateur.fromCoordoonneeToCoordonneeType(cu));
		}
		
		return myUt;
	}
}
