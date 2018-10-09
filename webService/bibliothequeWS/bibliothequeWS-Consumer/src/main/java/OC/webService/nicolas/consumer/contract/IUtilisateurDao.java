package OC.webService.nicolas.consumer.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import OC.webService.nicolas.model.entites.Utilisateur;

@Repository
public interface IUtilisateurDao extends JpaRepository<Utilisateur, Integer> {

	public Utilisateur findByPseudoAndMotDePasse(String pseudo, String motDePasse);
}
