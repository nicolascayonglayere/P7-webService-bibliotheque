package OC.webService.nicolas.business.contract;

import java.util.List;

import OC.webService.nicolas.model.entites.Livre;
import OC.webService.nicolas.model.entites.LivreEmprunt;
import OC.webService.nicolas.model.entites.Utilisateur;

public interface LivreEmpruntManager {

	public LivreEmprunt emprunterOuvrage(int pIdLivre, int pIdEmprunteur);
	
	public Livre retournerOuvrage(int pIdLivre, int pIdEmprunteur);
	
	public LivreEmprunt prolongerEmprunt(int pIdEmprunt);
	
	public LivreEmprunt findByIdEmprunt(int pIdEmprunt);
	
	public List<Utilisateur> obtenirRetardataires();
}
