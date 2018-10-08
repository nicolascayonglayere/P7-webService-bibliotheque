package OC.webService.nicolas.consumer.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import OC.webService.nicolas.model.entites.Utilisateur;

@Repository
public interface IUtilisateurDao extends JpaRepository<Utilisateur, Integer>{
	
	@Query("SELECT u FROM Utilisateur u JOIN FETCH u.coordonnee  WHERE u.pseudo =:pseudo AND u.motDePasse =:motDePasse")
	public Utilisateur findByPseudoAndMotDePasse(@Param("pseudo")String pseudo, @Param("motDePasse")String motDePasse);
	
	@Query("SELECT u FROM Utilisateur u JOIN FETCH u.coordonnee  WHERE u.id = :idUtilisateur")
	public Utilisateur findByIdUtilisateur(@Param("idUtilisateur")Integer pIdUtilisateur);
}
