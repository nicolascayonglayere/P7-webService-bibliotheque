package OC.webService.nicolas.consumer.contract;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import OC.webService.nicolas.model.entites.LivreEmprunt;
import OC.webService.nicolas.model.entites.Utilisateur;

@Repository
public interface ILivreEmpruntDao extends JpaRepository<LivreEmprunt, Integer> {

	@Query("SELECT l FROM LivreEmprunt l WHERE l.livre.id =:idLivre")
	public List<LivreEmprunt> findByLivreId(@Param("idLivre")Integer pId);
	
	@Query("SELECT l FROM LivreEmprunt l WHERE l.livre.id =:idLivre AND l.utilisateur.id =:idUtilisateur")
	public LivreEmprunt findByLivreIdAndUtilisateurId(@Param("idLivre")int pIdLivre, @Param("idUtilisateur")int pIdUtilisateur);
	
	@Query ("SELECT u FROM Utilisateur u JOIN FETCH u.coordonnee c JOIN u.emprunts e WHERE e.dateEmprunt >=:date AND u.id = c.utilisateur.id")
	public List<Utilisateur> findRetardataires(@Param("date")Date pDate);
	
	@Query("SELECT l FROM LivreEmprunt l JOIN l.utilisateur u JOIN u.coordonnee WHERE u.id =:idUtilisateur")
	public List<LivreEmprunt> findByUtilisateurId(@Param("idUtilisateur")int pIdUtilisateur);
	
	@Query("SELECT l FROM LivreEmprunt l JOIN FETCH l.livre li JOIN FETCH li.auteurs WHERE l.id = :idEmprunt")
	public LivreEmprunt findByIdEmprunt(@Param("idEmprunt")int pIdEmprunt);
}


