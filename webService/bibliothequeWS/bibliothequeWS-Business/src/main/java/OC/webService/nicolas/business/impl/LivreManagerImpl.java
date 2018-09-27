package OC.webService.nicolas.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import OC.webService.nicolas.business.contract.LivreManager;
import OC.webService.nicolas.consumer.contract.ILivreDao;
import OC.webService.nicolas.model.entites.Livre;

@Component
public class LivreManagerImpl implements LivreManager {

	@Autowired
	ILivreDao livreDao;
	
	@Override
	public List<Livre> obtenirNouveautes() {
		List<Livre> livresBiblio = livreDao.findAll();
		List<Livre> nouveautes = new ArrayList<Livre>();
		for (int i=livresBiblio.size(); i==(livresBiblio.size())-6; i--) {
			nouveautes.add(livresBiblio.get(i));
		}		
		
		return nouveautes;
	}

	public ILivreDao getLivreDao() {
		return livreDao;
	}

	public void setLivreDao(ILivreDao livreDao) {
		this.livreDao = livreDao;
	}

}
