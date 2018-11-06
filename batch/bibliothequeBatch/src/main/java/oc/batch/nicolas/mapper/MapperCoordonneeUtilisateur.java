package oc.batch.nicolas.mapper;

import fr.yogj.bibliows.types.CoordonneeUtilisateurType;
import fr.yogj.bibliows.types.UtilisateurType;
import oc.batch.nicolas.model.CoordonneeUtilisateur;
import oc.batch.nicolas.model.Utilisateur;

/**
 * Classe MapperCoordonneeUtilisateur pour mapper les propriétés d'un objet
 * {@link CoodonneeUtilisateurType} vers un objet {@link CoordonneeUtilisateur}
 * et inversement
 * 
 * @author nicolas
 *
 */
// @Transactional
public class MapperCoordonneeUtilisateur {

	/**
	 * Méthode depuis {@link CoordonneeUtilisateur} vers
	 * {@link CoordonneeUtilisateurType}
	 * 
	 * @param pCoordonneeUtilisateur
	 * @return {@link CoordonneeUTilisateurType}
	 */
	public static CoordonneeUtilisateurType fromCoordoonneeToCoordonneeType(
			CoordonneeUtilisateur pCoordonneeUtilisateur) {
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

	/**
	 * Méthode depuis {@link CoordonneeUtilisateurType} vers
	 * {@link CoordonneeUtilisateur}
	 * 
	 * @param pCoordonneeUtilisateurType
	 * @return
	 */
	public static CoordonneeUtilisateur frommCoordonneeTypeToCoordonnee(
			CoordonneeUtilisateurType pCoordonneeUtilisateurType) {
		CoordonneeUtilisateur myCu = new CoordonneeUtilisateur(pCoordonneeUtilisateurType.getId(),
				pCoordonneeUtilisateurType.getAdresse(), pCoordonneeUtilisateurType.getEmail());
		myCu.setId(pCoordonneeUtilisateurType.getId());

		Utilisateur user = new Utilisateur(pCoordonneeUtilisateurType.getUtilisateur().getId(),
				pCoordonneeUtilisateurType.getUtilisateur().getNom(),
				pCoordonneeUtilisateurType.getUtilisateur().getPrenom(),
				pCoordonneeUtilisateurType.getUtilisateur().getPseudo(),
				pCoordonneeUtilisateurType.getUtilisateur().getMotDePasse());
		user.setId(pCoordonneeUtilisateurType.getUtilisateur().getId());
		myCu.setUtilisateur(user);

		return myCu;
	}
}
