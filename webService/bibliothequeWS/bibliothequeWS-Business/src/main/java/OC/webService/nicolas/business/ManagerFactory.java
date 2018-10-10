package OC.webService.nicolas.business;

import OC.webService.nicolas.business.contract.LivreEmpruntManager;
import OC.webService.nicolas.business.contract.LivreManager;
import OC.webService.nicolas.business.contract.UtilisateurManager;

/**
 * Interface ManagerFactory qui permet l'accès aux différentes interfaces de la
 * couche business
 * 
 * @author nicolas
 *
 */
public interface ManagerFactory {

	LivreEmpruntManager getLivreEmpruntManager();

	void setLivreEmpruntManager(LivreEmpruntManager pLivreEmpruntManager);

	LivreManager getLivreManager();

	void setLivreManager(LivreManager pLivreManager);

	UtilisateurManager getUtilisateurManager();

	void setUtilisateurManager(UtilisateurManager pUtilisateurManager);
}
