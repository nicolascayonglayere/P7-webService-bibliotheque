package OC.webService.nicolas.consumer;

import OC.webService.nicolas.consumer.contract.ILivreDao;

public interface DaoFactory {
	ILivreDao getLivreDao( );

	void setLivreDao( ILivreDao livreDao );
}
