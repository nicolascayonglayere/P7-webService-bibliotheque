package OC.webService.nicolas.business.contract;

import java.util.List;

import OC.webService.nicolas.model.entites.Livre;
import OC.webService.nicolas.model.entites.LivreEmprunt;
import OC.webService.nicolas.model.entites.Utilisateur;

public interface LivreEmpruntManager {

	public LivreEmprunt emprunterOuvrage(int pIdLivre, int pIdEmprunteur) throws RuntimeException;
	
	public Livre retournerOuvrage(int pIdEmprunt) throws RuntimeException;
	
	public LivreEmprunt prolongerEmprunt(int pIdEmprunt) throws RuntimeException;
	
	public LivreEmprunt findByIdEmprunt(int pIdEmprunt);
	
	public List<Utilisateur> obtenirRetardataires();
	
	public List<LivreEmprunt> obtenirEmpruntUtilisateur(int pIdUtilisateur) throws RuntimeException;
}
