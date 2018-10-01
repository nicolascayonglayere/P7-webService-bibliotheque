package OC.webService.nicolas.appSpringBoot;

import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Holder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OC.webService.nicolas.appSpringBoot.helpers.ConversionDate;
import OC.webService.nicolas.business.contract.LivreManager;
import OC.webService.nicolas.model.entites.Auteur;
import OC.webService.nicolas.model.entites.Livre;
import fr.yogj.bibliows.BiblioWS;
import fr.yogj.bibliows.Deconnexion;
import fr.yogj.bibliows.DeconnexionFault_Exception;
import fr.yogj.bibliows.DeconnexionResponse;
import fr.yogj.bibliows.DetailsOuvrage;
import fr.yogj.bibliows.DetailsOuvrageFault_Exception;
import fr.yogj.bibliows.DetailsOuvrageResponse;
import fr.yogj.bibliows.EmpruntOuvrage;
import fr.yogj.bibliows.EmpruntOuvrageFault_Exception;
import fr.yogj.bibliows.EmpruntOuvrageResponse;

import fr.yogj.bibliows.ListNouveautesResponse;
import fr.yogj.bibliows.LoginFault_Exception;
import fr.yogj.bibliows.ProlongationOuvrage;
import fr.yogj.bibliows.ProlongationOuvrageFault1_Exception;
import fr.yogj.bibliows.ProlongationOuvrageFault_Exception;
import fr.yogj.bibliows.ProlongationOuvrageResponse;
import fr.yogj.bibliows.RetourOuvrage;
import fr.yogj.bibliows.RetourOuvrageFault1_Exception;
import fr.yogj.bibliows.RetourOuvrageFault_Exception;
import fr.yogj.bibliows.RetourOuvrageResponse;
import fr.yogj.bibliows.types.AuteurType;
import fr.yogj.bibliows.types.CoordonneeUtilisateurType;
import fr.yogj.bibliows.types.LivreType;
import fr.yogj.bibliows.types.UtilisateurType;

@Service
public class BiblioWSEndPoint implements BiblioWS {

	static final Logger logger = LogManager.getLogger();
	@Autowired
	LivreManager lm;
	
	//@Autowired
	ConversionDate convDate  = new ConversionDate();

	@Override
	public void listRetardataires(XMLGregorianCalendar dateDuJour, Holder<List<UtilisateurType>> utilisateur, Holder<CoordonneeUtilisateurType> coordonnee) {
		// TODO Auto-generated method stub

	}

	@Override
	public DeconnexionResponse deconnexion(Deconnexion parameters) throws DeconnexionFault_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmpruntOuvrageResponse empruntOuvrage(EmpruntOuvrage parameters) throws EmpruntOuvrageFault_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RetourOuvrageResponse retourOuvrage(RetourOuvrage parameters)
			throws RetourOuvrageFault_Exception, RetourOuvrageFault1_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProlongationOuvrageResponse prolongationOuvrage(ProlongationOuvrage parameters)
			throws ProlongationOuvrageFault_Exception, ProlongationOuvrageFault1_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UtilisateurType login(String pseudo, String motDePasse) throws LoginFault_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DetailsOuvrageResponse detailsOuvrage(DetailsOuvrage parameters) throws DetailsOuvrageFault_Exception {
		// TODO Auto-generated method stub
		return null;
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

}
