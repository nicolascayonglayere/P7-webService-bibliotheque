package OC.webService.nicolas.business.contract;

import OC.webService.nicolas.model.entites.LivreEmprunt;

public interface LivreEmpruntManager {

	public LivreEmprunt getLivreEmprunt(int pIdLivre, int pIdEmprunteur);
}
