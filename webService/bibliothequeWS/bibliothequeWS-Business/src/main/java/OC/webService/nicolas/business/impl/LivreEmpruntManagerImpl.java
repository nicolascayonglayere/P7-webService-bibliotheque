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

	@Transactional
	@Override
	public LivreEmprunt emprunterOuvrage(int pIdLivre, int pIdEmprunteur) throws RuntimeException {
		Livre l = getDaoFactory().getLivreDao().findByIdLivre(pIdLivre); 
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
			return livreEmprunt;
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
	}

	@Transactional
	@Override
	public Livre retournerOuvrage(int pIdEmprunt) throws RuntimeException{
		livreEmprunt = this.findByIdEmprunt(pIdEmprunt);		
		Livre l = this.getDaoFactory().getLivreDao().findByIdLivre((livreEmprunt.getLivre()).getId()); 
		if (l.getId() != 0) {
			this.getDaoFactory().getLivreEmpruntDao().delete(livreEmprunt);
			return l;			
		}
		else {
			throw new RuntimeException("Vous n'avez pas emprunte cet ouvrage.");
		}
		
	}
	@Transactional
	@Override
	public LivreEmprunt prolongerEmprunt(int pIdEmprunt) throws RuntimeException{
		if(this.findByIdEmprunt(pIdEmprunt).getId() != 0) {
			livreEmprunt = this.findByIdEmprunt(pIdEmprunt); 
			livreEmprunt.setProlongation(true);
			livreEmprunt.setDateEmprunt(Calendar.getInstance().getTime());
			this.getDaoFactory().getLivreEmpruntDao().saveAndFlush(livreEmprunt);
			return livreEmprunt;
		}else {
			throw new RuntimeException("Vous n'avez pas emprunté ce livre.");
		}			
	}
	@Transactional
	@Override
	public LivreEmprunt findByIdEmprunt(int pIdEmprunt) {
		livreEmprunt = getDaoFactory().getLivreEmpruntDao().findByIdEmprunt(pIdEmprunt);
		return livreEmprunt;
	}

	@Transactional
	@Override
	public List<Utilisateur> obtenirRetardataires() {
		List<Utilisateur> retardataires = new ArrayList<Utilisateur>();
		retardataires = getDaoFactory().getLivreEmpruntDao().findRetardataires(Calendar.getInstance().getTime());
		return retardataires;
	}

	@Transactional
	@Override
	public List<LivreEmprunt> obtenirEmpruntUtilisateur(int pIdUtilisateur) throws RuntimeException{
		List<LivreEmprunt> empruntsUtilisateur = getDaoFactory().getLivreEmpruntDao().findByUtilisateurId(pIdUtilisateur);
		if (empruntsUtilisateur.size() > 0) {
			return empruntsUtilisateur;
		}
		else {
			throw new RuntimeException ("L'utilisateur n'a pas d'emprunt en cours.");
		}
	}
	
	//public LivreEmprunt getLivreEmprunt() {
	//	return livreEmprunt;
	//}
	//
	//@Autowired
	//public void setLivreEmprunt(LivreEmprunt livreEmprunt) {
	//	this.livreEmprunt = livreEmprunt;
	//}
    







	
}
