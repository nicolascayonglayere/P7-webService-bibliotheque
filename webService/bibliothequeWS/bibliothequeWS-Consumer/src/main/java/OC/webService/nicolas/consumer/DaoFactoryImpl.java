package OC.webService.nicolas.consumer;

import OC.webService.nicolas.consumer.contract.ILivreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DaoFactoryImpl implements DaoFactory{

	private ILivreDao livreDao;

	@Override
	public ILivreDao getLivreDao( ) {
		return livreDao;
	}

	@Override
	@Autowired
	public void setLivreDao( ILivreDao livreDao ) {
		this.livreDao = livreDao;
	}
}
