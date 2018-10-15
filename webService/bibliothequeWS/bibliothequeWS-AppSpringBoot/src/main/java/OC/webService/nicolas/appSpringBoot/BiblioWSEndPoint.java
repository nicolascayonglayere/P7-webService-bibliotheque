package OC.webService.nicolas.appSpringBoot;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OC.webService.nicolas.appSpringBoot.helpers.MapperLivre;
import OC.webService.nicolas.appSpringBoot.helpers.MapperLivreEmprunt;
import OC.webService.nicolas.appSpringBoot.helpers.MapperUtilisateur;
import OC.webService.nicolas.business.ManagerFactory;
import OC.webService.nicolas.model.entites.Livre;
import OC.webService.nicolas.model.entites.LivreEmprunt;
import OC.webService.nicolas.model.entites.Utilisateur;
import fr.yogj.bibliows.BiblioWS;
import fr.yogj.bibliows.Deconnexion;
import fr.yogj.bibliows.DeconnexionFault_Exception;
import fr.yogj.bibliows.DetailsOuvrageFault_Exception;
import fr.yogj.bibliows.EmpruntOuvrageFault_Exception;
import fr.yogj.bibliows.ListNouveautesResponse;
import fr.yogj.bibliows.ListRetardatairesResponse;
import fr.yogj.bibliows.LoginFault_Exception;
import fr.yogj.bibliows.ObtenirEmpruntUtilisateurFault_Exception;
import fr.yogj.bibliows.ProlongationOuvrageFault1_Exception;
import fr.yogj.bibliows.RechercheOuvrage;
import fr.yogj.bibliows.RechercheOuvrageResponse;
import fr.yogj.bibliows.RetourOuvrageFault1_Exception;
import fr.yogj.bibliows.types.LivreEmpruntType;
import fr.yogj.bibliows.types.LivreType;
import fr.yogj.bibliows.types.UtilisateurType;

/**
 * Classe BiblioWSEndPoint implémentation de {@link BiblioWS}
 * 
 * @author nicolas
 *
 */
@Transactional
@Service
public class BiblioWSEndPoint implements BiblioWS {

	static final Logger logger = LogManager.getLogger();

	private ManagerFactory manageFacto;

	/**
	 * Méthode pour authentifier un {@link Utilisateur} à partir de son pseudo et de
	 * son mot de passe donnés en paramètre
	 */
	@Override
	public UtilisateurType login(String pseudo, String motDePasse) throws LoginFault_Exception {
		// TODO Auto-generated method stub on vérifie les login
		try {
			Utilisateur u = this.manageFacto.getUtilisateurManager().getUtilisateur(pseudo, motDePasse);
			UtilisateurType user = MapperUtilisateur.fromUtilisateurToUtilisateurType(u);
			return user;
		} catch (RuntimeException e) {
			logger.debug(e.getMessage());
			throw new LoginFault_Exception(e.getMessage());
		}
	}

	/**
	 * Méthode pour obtenir la liste de {@link Livre} nouveau
	 */
	@Override
	public ListNouveautesResponse listNouveautes(String parameters) {
		// TODO Auto-generated method stub
		ListNouveautesResponse nouveautes = new ListNouveautesResponse();

		for (Livre l : this.manageFacto.getLivreManager().obtenirNouveautes()) {
			LivreType livreType = MapperLivre.fromLivreToLivreType(l);
			nouveautes.getNouveautes().add(livreType);
		}
		return nouveautes;
	}

	/**
	 * Méthode pour obtenir la liste des {@link Utilisateur} en retard
	 */
	@Override
	public ListRetardatairesResponse listRetardataires(String parameters) {
		// TODO Auto-generated method stub
		ListRetardatairesResponse lrr = new ListRetardatairesResponse();
		for (Utilisateur u : this.manageFacto.getLivreEmpruntManager().obtenirRetardataires()) {
			UtilisateurType userType = MapperUtilisateur.fromUtilisateurToUtilisateurType(u);
			lrr.getUtilisateur().add(userType);

		}
		return lrr;
	}

	/**
	 * Méthode pour chercher un {@link Livre}
	 */
	@Override
	public RechercheOuvrageResponse rechercheOuvrage(RechercheOuvrage parameters) throws DetailsOuvrageFault_Exception {
		// TODO Auto-generated method stub
		RechercheOuvrageResponse rop = new RechercheOuvrageResponse();
		try {
			if (parameters.getIdLivre() != 0) {
				Livre livre = this.manageFacto.getLivreManager().trouverParId(parameters.getIdLivre());
				LivreType lt = MapperLivre.fromLivreToLivreType(livre);
				rop.getOuvrages().add(lt);
			} else {
				List<Livre> livres = this.manageFacto.getLivreManager().trouverParTitreEtAuteur(parameters.getTitre(),
						parameters.getAuteurNom());
				for (Livre l : livres) {
					LivreType lt = MapperLivre.fromLivreToLivreType(l);
					rop.getOuvrages().add(lt);
				}
			}
			return rop;
		} catch (RuntimeException e) {
			logger.debug(e.getMessage());
			throw new DetailsOuvrageFault_Exception(e.getMessage());
		}
	}

	/**
	 * Méthode pour prolonger un {@link LivreEmprunt}
	 */
	@Override
	public LivreEmpruntType prolongationOuvrage(int idEmprunt) throws ProlongationOuvrageFault1_Exception {
		// TODO Auto-generated method stub
		try {
			LivreEmprunt livreEmprunte = this.manageFacto.getLivreEmpruntManager().prolongerEmprunt(idEmprunt);
			LivreEmpruntType let = MapperLivreEmprunt.fromLivreEmpruntToLivreEmpruntType(livreEmprunte);
			return let;
		} catch (RuntimeException e) {
			logger.debug(e.getMessage());
			throw new ProlongationOuvrageFault1_Exception(e.getMessage());
		}
	}

	/**
	 * Méthode pour déconnecter un {@link Utilisateur}
	 */
	@Override
	public String deconnexion(Deconnexion parameters) throws DeconnexionFault_Exception {
		// TODO Auto-generated method stub
		try {
			this.manageFacto.getUtilisateurManager().getUtilisateur(parameters.getId());
			return "DECO OK";
		} catch (RuntimeException e) {
			logger.debug(e.getMessage());
			throw new DeconnexionFault_Exception("Erreur lors de la deconnexion");
		}
	}

	/**
	 * Méthode pour emprunter un {@link Livre}
	 */
	@Override
	public LivreEmpruntType empruntOuvrage(int idLivre, int idEmprunteur) throws EmpruntOuvrageFault_Exception {
		// TODO Auto-generated method stub
		try {
			LivreEmpruntType empruntType = MapperLivreEmprunt.fromLivreEmpruntToLivreEmpruntType(
					this.manageFacto.getLivreEmpruntManager().emprunterOuvrage(idLivre, idEmprunteur));
			return empruntType;
		} catch (RuntimeException e) {
			logger.debug(e.getMessage());
			throw new EmpruntOuvrageFault_Exception(e.getMessage());
		}

	}

	/**
	 * Méthode pour obtenir la liste des {@link LivreEmprunt} d'un
	 * {@link Utilisateur} d'id donné en paramètre
	 */
	@Override
	public List<LivreEmpruntType> obtenirEmpruntUtilisateur(int idUtilisateur)
			throws ObtenirEmpruntUtilisateurFault_Exception {
		// TODO Auto-generated method stub
		try {
			List<LivreEmprunt> livresEmpruntes = this.manageFacto.getLivreEmpruntManager()
					.obtenirEmpruntUtilisateur(idUtilisateur);
			List<LivreEmpruntType> ouvrages = new ArrayList<LivreEmpruntType>();
			for (LivreEmprunt le : livresEmpruntes) {
				LivreEmpruntType let = MapperLivreEmprunt.fromLivreEmpruntToLivreEmpruntType(le);
				ouvrages.add(let);
			}
			return ouvrages;
		} catch (RuntimeException e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
			throw new ObtenirEmpruntUtilisateurFault_Exception(e.getMessage());
		}

	}

	/**
	 * Méthode pour rendre un {@link LivreEmprunt} dont l'id est donné en paramètre
	 */
	@Override
	public LivreType retourOuvrage(int idLivreEmprunt) throws RetourOuvrageFault1_Exception {
		// TODO Auto-generated method stub
		try {
			Livre livreEmprunte = this.manageFacto.getLivreEmpruntManager().retournerOuvrage(idLivreEmprunt);
			LivreType lt = MapperLivre.fromLivreToLivreType(livreEmprunte);
			return lt;
		} catch (RuntimeException e) {
			logger.debug(e.getMessage());
			throw new RetourOuvrageFault1_Exception(e.getMessage());
		}

	}

	public ManagerFactory getManageFacto() {
		return this.manageFacto;
	}

	@Autowired
	public void setManageFacto(ManagerFactory manageFacto) {
		this.manageFacto = manageFacto;
	}

}
