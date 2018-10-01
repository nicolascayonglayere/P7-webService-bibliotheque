package OC.webService.nicolas.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import OC.webService.nicolas.business.contract.LivreManager;
import OC.webService.nicolas.model.entites.Livre;

@Component
public class LivreManagerImpl extends AbstractManager implements LivreManager {

//	@Autowired
//	ILivreDao livreDao;

	//private DaoFactory daoFactory;

	@Override
	public List<Livre> obtenirNouveautes() {

		List<Livre> livresBiblio = getDaoFactory().getLivreDao().findAll();
		List<Livre> nouveautes = new ArrayList<Livre>();

		for (int i=livresBiblio.size(); i==(livresBiblio.size())-6; i--) {
			nouveautes.add(livresBiblio.get(i));
		}

		return nouveautes;
	}

//	public ILivreDao getLivreDao() {
//		return livreDao;
//	}
//
//	@Autowired
//	public void setLivreDao(ILivreDao livreDao) {
//		this.livreDao = livreDao;
//	}

}
