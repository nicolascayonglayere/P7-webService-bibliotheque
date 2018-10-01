package OC.webService.nicolas.consumer;

import OC.webService.nicolas.consumer.contract.ILivreDao;
import OC.webService.nicolas.consumer.contract.IUtilisateurDao;

public interface DaoFactory {
	ILivreDao getLivreDao( );
	void setLivreDao( ILivreDao livreDao );
	
	IUtilisateurDao getUtilisateurDao();
	void setUtilisateurDao(IUtilisateurDao pUtilisateurDao);
}
