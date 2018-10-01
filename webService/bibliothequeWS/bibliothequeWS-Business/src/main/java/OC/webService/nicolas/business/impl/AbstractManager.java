package OC.webService.nicolas.business.impl;

import OC.webService.nicolas.consumer.DaoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public abstract class AbstractManager {

	private DaoFactory daoFactory;

	public DaoFactory getDaoFactory( ) {
		return daoFactory;
	}

	@Autowired
	public void setDaoFactory( DaoFactory daoFactory ) {
		this.daoFactory = daoFactory;
	}
}
