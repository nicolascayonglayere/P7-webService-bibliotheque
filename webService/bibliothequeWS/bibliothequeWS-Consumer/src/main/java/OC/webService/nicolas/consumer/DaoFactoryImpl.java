package OC.webService.nicolas.consumer;

import OC.webService.nicolas.consumer.contract.ILivreDao;
import OC.webService.nicolas.consumer.contract.IUtilisateurDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DaoFactoryImpl implements DaoFactory{

	private ILivreDao livreDao;
	private IUtilisateurDao userDao;

	@Override
	public ILivreDao getLivreDao( ) {
		return livreDao;
	}

	@Override
	@Autowired
	public void setLivreDao( ILivreDao livreDao ) {
		this.livreDao = livreDao;
	}

	@Override
	public IUtilisateurDao getUtilisateurDao() {
		return this.userDao;
	}
	
	@Autowired
	@Override
	public void setUtilisateurDao(IUtilisateurDao pUtilisateurDao) {
		this.userDao = pUtilisateurDao;
		
	}
}
