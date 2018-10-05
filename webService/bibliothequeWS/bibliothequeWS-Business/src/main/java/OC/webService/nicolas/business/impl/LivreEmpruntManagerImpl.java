package OC.webService.nicolas.business.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import OC.webService.nicolas.business.contract.LivreEmpruntManager;
import OC.webService.nicolas.model.entites.Livre;
import OC.webService.nicolas.model.entites.LivreEmprunt;
import OC.webService.nicolas.model.entites.Utilisateur;

@Transactional
@Component
public class LivreEmpruntManagerImpl extends AbstractManager implements LivreEmpruntManager {

	private LivreEmprunt livreEmprunt = new LivreEmprunt();

	@Override
	public LivreEmprunt emprunterOuvrage(int pIdLivre, int pIdEmprunteur) throws RuntimeException {
		Optional<Livre> myOptional = getDaoFactory().getLivreDao().findById(pIdLivre); 
		Livre l = myOptional.get();
		List<LivreEmprunt> ouvragesEmpruntes = this.getDaoFactory().getLivreEmpruntDao().findByLivreId(pIdLivre);
		int nbEx = l.getNbExemplaire() - ouvragesEmpruntes.size();
		
		if(nbEx > 0) {
			Optional<Utilisateur> myUserOptional = getDaoFactory().getUtilisateurDao().findById(pIdEmprunteur);
			Utilisateur user = myUserOptional.get();
			livreEmprunt.setLivre(l);  
			livreEmprunt.setProlongation(false);
			livreEmprunt.setDateEmprunt(Calendar.getInstance().getTime());
			livreEmprunt.setUtilisateur(user);
			this.getDaoFactory().getLivreEmpruntDao().saveAndFlush(livreEmprunt);
		}
		else {
			//recupérer la date de retour la plus proche
			Calendar cal = Calendar.getInstance();
			Date dateRetour = ouvragesEmpruntes.get(0).getDateEmprunt();
			cal.add(Calendar.DATE, 28);
			for (LivreEmprunt le : ouvragesEmpruntes) {
				cal.setTime(le.getDateEmprunt());
				cal.add(Calendar.DATE, 28);
				if ( cal.getTime().getTime() > dateRetour.getTime()) {
					dateRetour = cal.getTime();
				}
			}
			throw new RuntimeException ("Pas d'exemplaire disponible avant "+dateRetour);
		}

		return livreEmprunt;
	}

	@Override
	public Livre retournerOuvrage(int pIdEmprunt) {
		livreEmprunt = this.findByIdEmprunt(pIdEmprunt);		
		Optional<Livre> myOptional = getDaoFactory().getLivreDao().findById(livreEmprunt.getLivre().getId()); 
		Livre l = myOptional.get();
		this.getDaoFactory().getLivreEmpruntDao().delete(livreEmprunt);
		return l;
		
	}
	
	@Override
	public LivreEmprunt prolongerEmprunt(int pIdEmprunt) {
		livreEmprunt = this.findByIdEmprunt(pIdEmprunt); 
		livreEmprunt.setProlongation(true);
		livreEmprunt.setDateEmprunt(Calendar.getInstance().getTime());
		this.getDaoFactory().getLivreEmpruntDao().saveAndFlush(livreEmprunt);
		return livreEmprunt;
	}
	
	@Override
	public LivreEmprunt findByIdEmprunt(int pIdEmprunt) {
		Optional<LivreEmprunt> myOptional = getDaoFactory().getLivreEmpruntDao().findById(pIdEmprunt); 
		livreEmprunt = myOptional.get();
		return livreEmprunt;
	}

	@Override
	public List<Utilisateur> obtenirRetardataires() {
		List<Utilisateur> retardataires = new ArrayList<Utilisateur>();
		retardataires = getDaoFactory().getLivreEmpruntDao().findRetardataires(Calendar.getInstance().getTime());
		return retardataires;
	}

	@Override
	public List<LivreEmprunt> obtenirEmpruntUtilisateur(int pIdUtilisateur) {
		List<LivreEmprunt> empruntsUtilisateur = getDaoFactory().getLivreEmpruntDao().findByUtilisateurId(pIdUtilisateur);
		return empruntsUtilisateur;
	}
	
	///public LivreEmprunt getLivreEmprunt() {
	//	return livreEmprunt;
	//}
	//
	//@Autowired
	//public void setLivreEmprunt(LivreEmprunt livreEmprunt) {
	//	this.livreEmprunt = livreEmprunt;
	//}
    //







	
}
