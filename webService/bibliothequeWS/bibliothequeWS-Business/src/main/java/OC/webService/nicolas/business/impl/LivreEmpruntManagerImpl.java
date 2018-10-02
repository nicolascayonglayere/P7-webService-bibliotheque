package OC.webService.nicolas.business.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

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
	public LivreEmprunt emprunterOuvrage(int pIdLivre, int pIdEmprunteur) {
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

	@Override
	public Livre retournerOuvrage(int pIdLivre, int pIdEmprunteur) {
		livreEmprunte = getDaoFactory().getLivreEmpruntDao().findByLivreIdAndUtilisateurId(pIdLivre, pIdEmprunteur);
		this.getDaoFactory().getLivreEmpruntDao().delete(livreEmprunte);
		Optional<Livre> myOptional = getDaoFactory().getLivreDao().findById(pIdLivre); 
		Livre l = myOptional.get();
		return l;
		
	}
	
	@Override
	public LivreEmprunt prolongerEmprunt(int pIdEmprunt) {
		livreEmprunte = this.findByIdEmprunt(pIdEmprunt); 
		livreEmprunte.setProlongation(true);
		livreEmprunte.setDateEmprunt(Calendar.getInstance().getTime());
		this.getDaoFactory().getLivreEmpruntDao().saveAndFlush(livreEmprunte);
		return livreEmprunte;
	}
	
	@Override
	public LivreEmprunt findByIdEmprunt(int pIdEmprunt) {
		Optional<LivreEmprunt> myOptional = getDaoFactory().getLivreEmpruntDao().findById(pIdEmprunt); 
		livreEmprunte = myOptional.get();
		return livreEmprunte;
	}

	@Override
	public List<Utilisateur> obtenirRetardataires() {
		List<Utilisateur> retardataires = new ArrayList<Utilisateur>();
		retardataires = getDaoFactory().getLivreEmpruntDao().findRetardataires(Calendar.getInstance().getTime());
		return retardataires;
	}
	
	public LivreEmprunt getLivreEmprunte() {
		return livreEmprunte;
	}
	
	@Autowired
	public void setLivreEmprunte(LivreEmprunt livreEmprunte) {
		this.livreEmprunte = livreEmprunte;
	}








	
}
