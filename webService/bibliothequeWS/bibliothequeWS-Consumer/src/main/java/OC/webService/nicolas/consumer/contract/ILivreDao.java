package OC.webService.nicolas.consumer.contract;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import OC.webService.nicolas.model.entites.Auteur;
import OC.webService.nicolas.model.entites.Livre;

import java.util.List;

@Repository
public interface ILivreDao extends JpaRepository<Livre, Integer> {

	//public List<Livre> obtenirLivres();

	//public Livre obtenirDetailsLivre(int pId);

//	public Livre trouverLivre(String pTitre, Auteur pAuteur);
	public Livre findByTitreAndAuteurs(String pTitre, Auteur pAuteur);

//	@Query("SELECT r.role FROM Role r JOIN r.users u WHERE u.email =:email")
//	public List<String> findRoleByEmail( @Param( "email" ) String email );
}
