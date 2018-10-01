package OC.webService.nicolas.business.impl;

import java.util.Calendar;
import java.util.Optional;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import OC.webService.nicolas.business.contract.LivreEmpruntManager;
import OC.webService.nicolas.model.entites.Livre;
import OC.webService.nicolas.model.entites.LivreEmprunt;
import OC.webService.nicolas.model.entites.Utilisateur;

@Component
public class LivreEmpruntManagerImpl extends AbstractManager implements LivreEmpruntManager {

	LivreEmprunt livreEmprunte;

	@Override
	public LivreEmprunt getLivreEmprunt(int pIdLivre, int pIdEmprunteur) {
		Optional<Livre> myOptional = getDaoFactory().getLivreDao().findById(pIdLivre); 
		Livre l = myOptional.get();
		Optional<Utilisateur> myUserOptional = getDaoFactory().getUtilisateurDao().findById(pIdEmprunteur);
		Utilisateur user = myUserOptional.get();
		livreEmprunte.setLivre(l);  
		livreEmprunte.setProlongation(false);
		livreEmprunte.setDateEmprunt(Calendar.getInstance().getTime());
		livreEmprunte.setUtilisateur(user);
		this.getDaoFactory().getLivreEmpruntDao().saveAndFlush(livreEmprunte);
		return livreEmprunte;
	}

	public LivreEmprunt getLivreEmprunte() {
		return livreEmprunte;
	}
	
	@Autowired
	public void setLivreEmprunte(LivreEmprunt livreEmprunte) {
		this.livreEmprunte = livreEmprunte;
	}

	
}
