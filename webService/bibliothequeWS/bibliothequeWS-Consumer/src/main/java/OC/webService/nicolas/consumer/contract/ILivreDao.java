package OC.webService.nicolas.consumer.contract;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import OC.webService.nicolas.model.entites.Livre;

@Repository
public interface ILivreDao extends JpaRepository<Livre, Integer> {

	@Query("SELECT l FROM Livre l JOIN FETCH l.auteurs a WHERE l.titre LIKE %:titre% AND a.nom LIKE %:nom%")
	public List<Livre> findByTitreAndAuteurs(@Param("titre")String pTitre, @Param("nom")String pNom);
	
	@Query("SELECT l FROM Livre l JOIN FETCH l.auteurs WHERE l.id = :id")
	public Livre findByIdLivre(@Param("id")Integer pId);

}
