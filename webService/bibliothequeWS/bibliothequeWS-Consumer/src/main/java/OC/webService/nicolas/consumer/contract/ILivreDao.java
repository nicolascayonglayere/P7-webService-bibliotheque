package OC.webService.nicolas.consumer.contract;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import OC.webService.nicolas.model.entites.Livre;

@Repository
public interface ILivreDao extends JpaRepository<Livre, Integer> {

	@Query("SELECT l FROM Livre l JOIN l.auteurs a WHERE l.titre =:titre AND a.nom LIKE %:nom%")
	public Livre findByTitreAndAuteurs(@Param("titre")String pTitre, @Param("nom")String pNom);

}
