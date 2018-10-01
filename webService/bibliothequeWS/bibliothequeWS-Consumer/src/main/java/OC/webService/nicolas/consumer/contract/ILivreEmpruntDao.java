package OC.webService.nicolas.consumer.contract;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import OC.webService.nicolas.model.entites.LivreEmprunt;

@Repository
public interface ILivreEmpruntDao extends JpaRepository<LivreEmprunt, Integer> {

	@Query("SELECT l FROM LivreEmprunt WHERE l.id_livre =: idLivre")
	public List<LivreEmprunt> findByLivreId(@Param("idLivre")int pId);
}
