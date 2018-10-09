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

	public List<LivreEmprunt> findByLivreId(Integer pId);

	public LivreEmprunt findByLivreIdAndUtilisateurId(int pIdLivre, int pIdUtilisateur);

	@Query("SELECT u FROM Utilisateur u JOIN FETCH u.coordonnee c JOIN u.emprunts e WHERE e.dateEmprunt >=:date AND u.id = c.utilisateur.id")
	public List<Utilisateur> findRetardataires(@Param("date") Date pDate);

	public List<LivreEmprunt> findByUtilisateurId(int pIdUtilisateur);

}
