package OC.webService.nicolas.appSpringBoot;

import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Holder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OC.webService.nicolas.appSpringBoot.helpers.ConversionDate;
import OC.webService.nicolas.business.contract.LivreEmpruntManager;
import OC.webService.nicolas.business.contract.LivreManager;
import OC.webService.nicolas.business.contract.UtilisateurManager;
import OC.webService.nicolas.model.entites.Auteur;
import OC.webService.nicolas.model.entites.CoordonneeUtilisateur;
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
import fr.yogj.bibliows.ProlongationOuvrageFault_Exception;
import fr.yogj.bibliows.RechercheOuvrage;
import fr.yogj.bibliows.RechercheOuvrageResponse;
import fr.yogj.bibliows.RetourOuvrageFault1_Exception;
import fr.yogj.bibliows.RetourOuvrageFault_Exception;
import fr.yogj.bibliows.types.AuteurType;
import fr.yogj.bibliows.types.CoordonneeUtilisateurType;
import fr.yogj.bibliows.types.LivreEmpruntType;
import fr.yogj.bibliows.types.LivreType;
import fr.yogj.bibliows.types.UtilisateurType;

@Service
public class BiblioWSEndPoint implements BiblioWS {

	static final Logger logger = LogManager.getLogger();
	@Autowired
	private LivreManager lm;
	@Autowired
	private UtilisateurManager um;
	@Autowired
	private LivreEmpruntManager lem;
	
	
	//@Autowired
	ConversionDate convDate  = new ConversionDate();

	@Override
	public UtilisateurType login(String pseudo, String motDePasse) throws LoginFault_Exception {
		// TODO Auto-generated method stub on vérifie les login
		Utilisateur u = um.getUtilisateur(pseudo, motDePasse);
		UtilisateurType user = new UtilisateurType();
		user.setId(u.getId());
		user.setPseudo(u.getPseudo());
		user.setMotDePasse(u.getMotDePasse());
		user.setNom(u.getNom());
		user.setPrenom(u.getPrenom());
		
		return user;
	}

	@Override
	public ListNouveautesResponse listNouveautes(String parameters) {
		// TODO Auto-generated method stub
		ListNouveautesResponse nouveautes = new ListNouveautesResponse();

		for (Livre l : lm.obtenirNouveautes()) {
			LivreType livreType = new LivreType();
			livreType.setId(l.getId());
			livreType.setTitre(l.getTitre());
			livreType.setGenre(l.getGenre().toString());
			livreType.setNbExemplaire(l.getNbExemplaire());
			try {
				livreType.setDate(convDate.convertirDateXML(l.getDateParution()));
			} catch (DatatypeConfigurationException e) {
				e.printStackTrace();
				logger.debug(e.getMessage());
				System.out.println(e.getMessage());
				
				
			}
			
			for (Auteur a : l.getAuteurs()) {
				AuteurType autType = new AuteurType();
				autType.setId(a.getId());
				try {
					autType.setDateDeNaissance(convDate.convertirDateXML(a.getDateNaissance()));
				} catch (DatatypeConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					logger.debug(e.getMessage());
					System.out.println(e.getMessage());
				}
				autType.setNationalite(a.getNationalite());
				autType.getPrenom().add(a.getPrenom());
				autType.getNom().add(a.getNom());
				livreType.getAuteurs().add(autType);
			}
			nouveautes.getNouveautes().add(livreType);
		}
		//nouveautes.getNouveautes().addAll((LivreType)lm.obtenirNouveautes());
		return nouveautes;
	}

	@Override
	public ListRetardatairesResponse listRetardataires(String parameters) {
		// TODO Auto-generated method stub
		ListRetardatairesResponse lrr = new ListRetardatairesResponse();
		for (Utilisateur u : lem.obtenirRetardataires()) {
			UtilisateurType userType = new UtilisateurType();
			userType.setId(u.getId());
			userType.setNom(u.getNom());
			userType.setPrenom(u.getPrenom());
			userType.setPseudo(u.getPseudo());
			userType.setMotDePasse(u.getMotDePasse());
			
			CoordonneeUtilisateurType coordType = new CoordonneeUtilisateurType();
			for (CoordonneeUtilisateur cu : u.getCoordonnee()) {
				coordType.setId(cu.getId());
				coordType.setEmail(cu.getEmail());
				coordType.setAdresse(cu.getAdresse());
				userType.getCoordonnee().add(coordType);
			}
			
			lrr.getUtilisateur().add(userType);
			
		}
		return lrr;
	}

	@Override
	public RechercheOuvrageResponse rechercheOuvrage(RechercheOuvrage parameters) throws DetailsOuvrageFault_Exception {
		// TODO Auto-generated method stub
		RechercheOuvrageResponse rop = new RechercheOuvrageResponse();
		List<Livre> livres = lm.trouverParTitreEtAuteur(parameters.getTitre(), parameters.getAuteurNom());
		for (Livre l:livres) {
			LivreType lt = new LivreType();
			lt.setId(l.getId());
			lt.setTitre(l.getTitre());
			lt.setGenre(l.getGenre());
			lt.setNbExemplaire(l.getNbExemplaire());
			try {
				lt.setDate(convDate.convertirDateXML(l.getDateParution()));
			} catch (DatatypeConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(Auteur a : l.getAuteurs()) {
				AuteurType auteurT = new AuteurType();
				auteurT.setId(a.getId());
				auteurT.setNationalite(a.getNationalite());
				try {
					auteurT.setDateDeNaissance(convDate.convertirDateXML(a.getDateNaissance()));
				} catch (DatatypeConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				auteurT.getNom().add(a.getNom());
				auteurT.getPrenom().add(a.getPrenom());
				lt.getAuteurs().add(auteurT);
			}	
			rop.getOuvrages().add(lt);
		}

		return rop;
	}

	@Override
	public LivreEmpruntType prolongationOuvrage(int idEmprunt) throws ProlongationOuvrageFault_Exception, ProlongationOuvrageFault1_Exception {
		// TODO Auto-generated method stub
		LivreEmprunt livreEmprunte = this.lem.prolongerEmprunt(idEmprunt);
		LivreEmpruntType let = new LivreEmpruntType();
		let.setId(livreEmprunte.getId());
		try {
			let.setDateEmprunt(convDate.convertirDateXML(livreEmprunte.getDateEmprunt()));
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LivreType lt = new LivreType();
		lt.setId(livreEmprunte.getLivre().getId());
		lt.setTitre(livreEmprunte.getLivre().getTitre());
		lt.setGenre(livreEmprunte.getLivre().getGenre());
		lt.setNbExemplaire(livreEmprunte.getLivre().getNbExemplaire());
		try {
			lt.setDate(convDate.convertirDateXML(livreEmprunte.getLivre().getDateParution()));
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Auteur a : livreEmprunte.getLivre().getAuteurs()) {
			AuteurType auteurT = new AuteurType();
			auteurT.setId(a.getId());
			auteurT.setNationalite(a.getNationalite());
			try {
				auteurT.setDateDeNaissance(convDate.convertirDateXML(a.getDateNaissance()));
			} catch (DatatypeConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			auteurT.getNom().add(a.getNom());
			auteurT.getPrenom().add(a.getPrenom());
			lt.getAuteurs().add(auteurT);
		}

		let.setOuvrage(lt); 
		
		UtilisateurType userType = new UtilisateurType();
		userType.setId(livreEmprunte.getUtilisateur().getId());
		userType.setNom(livreEmprunte.getUtilisateur().getNom());
		userType.setPrenom(livreEmprunte.getUtilisateur().getPrenom());
		userType.setPseudo(livreEmprunte.getUtilisateur().getPseudo());
		userType.setMotDePasse(livreEmprunte.getUtilisateur().getMotDePasse());
		
		let.setEmprunteur(userType);
		return let;
	}

	@Override
	public String deconnexion(Deconnexion parameters) throws DeconnexionFault_Exception {
		// TODO Auto-generated method stub
		Utilisateur u = um.getUtilisateur(parameters.getId());
		return "DECO OK";
	}

	@Override
	public LivreEmpruntType empruntOuvrage(int idLivre, int idEmprunteur) throws EmpruntOuvrageFault_Exception {
		// TODO Auto-generated method stub Mapper le LivreEmprunt au livreEmpruntType
		this.lem.emprunterOuvrage(idLivre, idEmprunteur);
		return null;
	}

	@Override
	public List<LivreEmpruntType> obtenirEmpruntUtilisateur(int idUtilisateur) throws ObtenirEmpruntUtilisateurFault_Exception {
		// TODO Auto-generated method stub
		List<LivreEmprunt> livresEmpruntes = this.lem.obtenirEmpruntUtilisateur(idUtilisateur);
		List<LivreEmpruntType> ouvrages = new ArrayList<LivreEmpruntType>();
		for(LivreEmprunt le : livresEmpruntes) {
			LivreEmpruntType let = new LivreEmpruntType();
			let.setId(le.getId());
			try {
				let.setDateEmprunt(convDate.convertirDateXML(le.getDateEmprunt()));
			} catch (DatatypeConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			LivreType lt = new LivreType();
			lt.setId(le.getLivre().getId());
			lt.setTitre(le.getLivre().getTitre());
			lt.setGenre(le.getLivre().getGenre());
			lt.setNbExemplaire(le.getLivre().getNbExemplaire());
			try {
				lt.setDate(convDate.convertirDateXML(le.getLivre().getDateParution()));
			} catch (DatatypeConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (Auteur a : le.getLivre().getAuteurs()) {
				AuteurType auteurT = new AuteurType();
				auteurT.setId(a.getId());
				auteurT.setNationalite(a.getNationalite());
				try {
					auteurT.setDateDeNaissance(convDate.convertirDateXML(a.getDateNaissance()));
				} catch (DatatypeConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				auteurT.getNom().add(a.getNom());
				auteurT.getPrenom().add(a.getPrenom());
				lt.getAuteurs().add(auteurT);
			}

			let.setOuvrage(lt); 
			
			UtilisateurType userType = new UtilisateurType();
			userType.setId(le.getUtilisateur().getId());
			userType.setNom(le.getUtilisateur().getNom());
			userType.setPrenom(le.getUtilisateur().getPrenom());
			userType.setPseudo(le.getUtilisateur().getPseudo());
			userType.setMotDePasse(le.getUtilisateur().getMotDePasse());
			
			let.setEmprunteur(userType);	
			
			ouvrages.add(let);
		}

		return ouvrages;
	}

	@Override
	public LivreType retourOuvrage(int idLivreEmprunt) throws RetourOuvrageFault_Exception, RetourOuvrageFault1_Exception {
		// TODO Auto-generated method stub
		LivreType lt = new LivreType();
		Livre livreEmprunte = lem.retournerOuvrage(idLivreEmprunt);
		lt.setId(livreEmprunte.getId());
		lt.setGenre(livreEmprunte.getGenre());
		lt.setTitre(livreEmprunte.getTitre());
		lt.setNbExemplaire(livreEmprunte.getNbExemplaire());//A checker
		try {
			lt.setDate(convDate.convertirDateXML(livreEmprunte.getDateParution()));
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Auteur a : livreEmprunte.getAuteurs()) {
			AuteurType auteurT = new AuteurType();
			auteurT.setId(a.getId());
			auteurT.setNationalite(a.getNationalite());
			try {
				auteurT.setDateDeNaissance(convDate.convertirDateXML(a.getDateNaissance()));
			} catch (DatatypeConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			auteurT.getNom().add(a.getNom());
			auteurT.getPrenom().add(a.getPrenom());
			lt.getAuteurs().add(auteurT);
		}
		
		return lt;		
	}

}
