package OC.webService.nicolas.business.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import OC.webService.nicolas.business.contract.LivreEmpruntManager;
import OC.webService.nicolas.model.entites.Livre;
import OC.webService.nicolas.model.entites.LivreEmprunt;
import OC.webService.nicolas.model.entites.Utilisateur;

/**
 * Implémentation de {@link LivreEmpruntManager}
 * 
 * @author nicolas
 *
 */
@Component
public class LivreEmpruntManagerImpl extends AbstractManager implements LivreEmpruntManager {

	static final Logger logger = LogManager.getLogger();
	private LivreEmprunt livreEmprunt;// = new LivreEmprunt();

	/**
	 * Méthode pour emprunter un {@link Livre}
	 */
	@Override
	public LivreEmprunt emprunterOuvrage(int pIdLivre, int pIdEmprunteur) throws RuntimeException {
		Optional<Livre> myOptional = this.getDaoFactory().getLivreDao().findById(pIdLivre);
		Livre l = myOptional.get();
		List<LivreEmprunt> ouvragesEmpruntes = this.getDaoFactory().getLivreEmpruntDao().findByLivreId(pIdLivre);
		int nbEx = l.getNbExemplaire() - ouvragesEmpruntes.size();
		logger.debug("nb exemplaires restants : " + nbEx);
		if (nbEx > 0) {
			Optional<Utilisateur> myUserOptional = this.getDaoFactory().getUtilisateurDao().findById(pIdEmprunteur);
			Utilisateur user = myUserOptional.get();
			this.livreEmprunt.setLivre(l);
			this.livreEmprunt.setProlongation(false);
			this.livreEmprunt.setDateEmprunt(Calendar.getInstance().getTime());
			this.livreEmprunt.setUtilisateur(user);
			return this.getDaoFactory().getLivreEmpruntDao().saveAndFlush(this.livreEmprunt);

		} else {
			// recupérer la date de retour la plus proche
			Calendar cal = Calendar.getInstance();
			Date dateRetour = ouvragesEmpruntes.get(0).getDateEmprunt();
			for (LivreEmprunt le : ouvragesEmpruntes) {
				cal.setTime(le.getDateEmprunt());
				cal.add(Calendar.DATE, 28);
				if (cal.getTime().getTime() > dateRetour.getTime()) {
					dateRetour = cal.getTime();
				}
			}
			throw new RuntimeException("Pas d'exemplaire disponible avant " + dateRetour);
		}
	}

	/**
	 * Méthode pour rendre un {@link LivreEmprunt}
	 */
	@Override
	public Livre retournerOuvrage(int pIdEmprunt) throws RuntimeException {
		this.livreEmprunt = this.findByIdEmprunt(pIdEmprunt);
		Optional<Livre> myOptional = this.getDaoFactory().getLivreDao()
				.findById((this.livreEmprunt.getLivre()).getId());
		Livre l = myOptional.get();
		if (l.getId() != 0) {
			this.getDaoFactory().getLivreEmpruntDao().delete(this.livreEmprunt);
			l.setNbExemplaire(l.getNbExemplaire() + 1);
			return l;
		} else {
			throw new RuntimeException("Vous n'avez pas emprunte cet ouvrage.");
		}

	}

	/**
	 * Méthode pour prolonger un {@link LivreEmprunt}
	 */
	@Override
	public LivreEmprunt prolongerEmprunt(int pIdEmprunt) throws RuntimeException {
		if (this.findByIdEmprunt(pIdEmprunt).getId() != 0) {
			this.livreEmprunt = this.findByIdEmprunt(pIdEmprunt);
			this.livreEmprunt.setProlongation(true);
			this.livreEmprunt.setDateEmprunt(Calendar.getInstance().getTime());
			this.getDaoFactory().getLivreEmpruntDao().saveAndFlush(this.livreEmprunt);
			return this.livreEmprunt;
		} else {
			throw new RuntimeException("Vous n'avez pas emprunté ce livre.");
		}
	}

	/**
	 * Méthode pour trouver un {@link LivreEmprunt}
	 */
	@Override
	public LivreEmprunt findByIdEmprunt(int pIdEmprunt) {
		Optional<LivreEmprunt> myOptional = this.getDaoFactory().getLivreEmpruntDao().findById(pIdEmprunt);
		this.livreEmprunt = myOptional.get();
		return this.livreEmprunt;
	}

	/**
	 * Méthode pour obtenir les {@link Utilisateurs} en retard
	 */
	@Override
	public List<Utilisateur> obtenirRetardataires() {
		List<Utilisateur> retardataires = new ArrayList<Utilisateur>();
		Calendar cal = Calendar.getInstance();

		cal.add(Calendar.DATE, -28);
		logger.debug("date emprunt en retard : " + cal.getTime());
		retardataires = this.getDaoFactory().getLivreEmpruntDao().findRetardataires(cal.getTime());
		return retardataires;
	}

	/**
	 * Méthode pour trouver la liste des {@link LivreEmprunt} d'un
	 * {@link Utilisateur} d'id donné en paramètre
	 */
	@Override
	public List<LivreEmprunt> obtenirEmpruntUtilisateur(int pIdUtilisateur) throws RuntimeException {
		List<LivreEmprunt> empruntsUtilisateur = this.getDaoFactory().getLivreEmpruntDao()
				.findByUtilisateurId(pIdUtilisateur);
		if (empruntsUtilisateur.size() > 0) {
			return empruntsUtilisateur;
		} else {
			throw new RuntimeException("L'utilisateur n'a pas d'emprunt en cours.");
		}
	}

	public LivreEmprunt getLivreEmprunt() {
		return this.livreEmprunt;
	}

	@Autowired
	public void setLivreEmprunt(LivreEmprunt livreEmprunt) {
		this.livreEmprunt = livreEmprunt;
	}

}
