package OC.webService.nicolas.appSpringBoot.helpers;

import OC.webService.nicolas.model.entites.CoordonneeUtilisateur;
import OC.webService.nicolas.model.entites.Utilisateur;
import fr.yogj.bibliows.types.CoordonneeUtilisateurType;
import fr.yogj.bibliows.types.UtilisateurType;

public class MapperCoordonneeUtilisateur {

	
	public static CoordonneeUtilisateurType fromCoordoonneeToCoordonneeType(CoordonneeUtilisateur pCoordonneeUtilisateur) {
		CoordonneeUtilisateurType myCut = new CoordonneeUtilisateurType();
		myCut.setId(pCoordonneeUtilisateur.getId());
		myCut.setEmail(pCoordonneeUtilisateur.getEmail());
		myCut.setAdresse(pCoordonneeUtilisateur.getAdresse());
		
		UtilisateurType ut = new UtilisateurType();
		ut.setId(pCoordonneeUtilisateur.getUtilisateur().getId());
		ut.setNom(pCoordonneeUtilisateur.getUtilisateur().getNom());
		ut.setPrenom(pCoordonneeUtilisateur.getUtilisateur().getPrenom());
		ut.setPseudo(pCoordonneeUtilisateur.getUtilisateur().getPseudo());
		ut.setMotDePasse(pCoordonneeUtilisateur.getUtilisateur().getMotDePasse());

		myCut.setUtilisateur(ut);
		
		return myCut;
	}
	
	public static CoordonneeUtilisateur frommCoordonneeTypeToCoordonnee(CoordonneeUtilisateurType pCoordonneeUtilisateurType) {
		CoordonneeUtilisateur myCu = new CoordonneeUtilisateur(pCoordonneeUtilisateurType.getAdresse(), pCoordonneeUtilisateurType.getEmail());
		myCu.setId(pCoordonneeUtilisateurType.getId());
		
		Utilisateur user = new Utilisateur(pCoordonneeUtilisateurType.getUtilisateur().getNom(), pCoordonneeUtilisateurType.getUtilisateur().getPrenom(), 
				pCoordonneeUtilisateurType.getUtilisateur().getPseudo(), pCoordonneeUtilisateurType.getUtilisateur().getMotDePasse());
		user.setId(pCoordonneeUtilisateurType.getUtilisateur().getId());
		myCu.setUtilisateur(user);
		
		return myCu;
	}
}
