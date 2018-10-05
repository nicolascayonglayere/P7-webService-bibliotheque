package OC.webService.nicolas.appSpringBoot.helpers;

import java.util.Date;

import javax.xml.datatype.DatatypeConfigurationException;

import OC.webService.nicolas.model.entites.LivreEmprunt;
import fr.yogj.bibliows.types.LivreEmpruntType;

public class MapperLivreEmprunt {

	//@Autowired
	private static ConversionDate convDate  = new ConversionDate();
	
	public static LivreEmprunt fromLivreEmpruntTypeToLivreEmprunt(LivreEmpruntType pLivreEmpruntType) {
		Date dateEmprunt = getConvDate().convertirXMLGregorianCalendar(pLivreEmpruntType.getDateEmprunt());
		LivreEmprunt monEmprunt = new LivreEmprunt(dateEmprunt, pLivreEmpruntType.isProlongation());
		monEmprunt.setId(pLivreEmpruntType.getId());
		monEmprunt.setLivre(MapperLivre.fromLivreTypeToLivre(pLivreEmpruntType.getOuvrage()));
		monEmprunt.setUtilisateur(MapperUtilisateur.fromUtilisateurTypeToUtilisateur(pLivreEmpruntType.getEmprunteur()));
		
		return monEmprunt;
		
	}
	
	public static LivreEmpruntType fromLivreEmpruntToLivreEmpruntType(LivreEmprunt pLivreEmprunt) {
		LivreEmpruntType myLet = new LivreEmpruntType();
		myLet.setId(pLivreEmprunt.getId());
		myLet.setProlongation(pLivreEmprunt.isProlongation());
		try {
			myLet.setDateEmprunt(getConvDate().convertirDateXML(pLivreEmprunt.getDateEmprunt()));
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myLet.setOuvrage(MapperLivre.fromLivreToLivreType(pLivreEmprunt.getLivre()));
		myLet.setEmprunteur(MapperUtilisateur.fromUtilisateurToUtilisateurType(pLivreEmprunt.getUtilisateur()));		
		
		return myLet;
	}

	public static ConversionDate getConvDate() {
		return convDate;
	}

	public static void setConvDate(ConversionDate convDate) {
		MapperLivreEmprunt.convDate = convDate;
	}
	
	
}
