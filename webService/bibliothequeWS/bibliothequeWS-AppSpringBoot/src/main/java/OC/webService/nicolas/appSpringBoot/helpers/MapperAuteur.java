package OC.webService.nicolas.appSpringBoot.helpers;

import java.util.Date;

import javax.xml.datatype.DatatypeConfigurationException;

import OC.webService.nicolas.model.entites.Auteur;
import OC.webService.nicolas.model.entites.Livre;
import fr.yogj.bibliows.types.AuteurType;
import fr.yogj.bibliows.types.LivreType;

public class MapperAuteur {
	
	//@Autowired
	private static ConversionDate convDate  = new ConversionDate();
	
	public static AuteurType fromAuteurToAuteurType(Auteur pAuteur) {
		AuteurType monType = new AuteurType();
		monType.setId(pAuteur.getId());
		monType.setNationalite(pAuteur.getNationalite());
		monType.setNom(pAuteur.getNom());
		monType.setPrenom(pAuteur.getPrenom());
		try {
			monType.setDateDeNaissance(getConvDate().convertirDateXML(pAuteur.getDateNaissance()));
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Livre l : pAuteur.getManuscrits()) {
			LivreType lt = MapperLivre.fromLivreToLivreType(l);
			monType.getManuscrits().add(lt);
		}		
		
		return monType;
	}
	
	public static Auteur fromAuteurTypeToAuteur(AuteurType pAuteurType) {
		Date dateNaissance = getConvDate().convertirXMLGregorianCalendar(pAuteurType.getDateDeNaissance());
		Auteur monAuteur = new Auteur(pAuteurType.getNom(), pAuteurType.getPrenom(), dateNaissance, pAuteurType.getNationalite());
		monAuteur.setId(pAuteurType.getId());
		for (LivreType lt : pAuteurType.getManuscrits()) {
			Livre l = MapperLivre.fromLivreTypeToLivre(lt);
			monAuteur.getManuscrits().add(l);
		}
		
		return monAuteur;
	}

	public static ConversionDate getConvDate() {
		return convDate;
	}

	public void setConvDate(ConversionDate convDate) {
		this.convDate = convDate;
	}

}
