package OC.webService.nicolas.consumer.contract;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import OC.webService.nicolas.model.entites.Auteur;
import OC.webService.nicolas.model.entites.Livre;

@Repository
public interface ILivreDao extends JpaRepository<Livre, Integer> {

	//public List<Livre> obtenirLivres();
	
	//public Livre obtenirDetailsLivre(int pId);
	
	public Livre trouverLivre(String pTitre, Auteur pAuteur);
}
