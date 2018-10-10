package OC.webService.nicolas.appSpringBoot.helpers;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Component;

/**
 * Classe ConversionDate pour convertir la date reçue dans la requete SOAP en
 * objet Date
 * 
 * @author nicolas
 *
 */
@Component
public class ConversionDate {
	/**
	 * Constructeur sans paramètre
	 */
	public ConversionDate() {
	}

	/**
	 * Méthode de conversion vers une date SOAP
	 * 
	 * @param pDate
	 * @return {@link XMLGregorianCalendar}
	 * @throws DatatypeConfigurationException
	 */
	public XMLGregorianCalendar convertirDateXML(Date pDate) throws DatatypeConfigurationException {
		GregorianCalendar gregory = new GregorianCalendar();
		gregory.setTime(pDate);
		XMLGregorianCalendar calendar;

		calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory);

		return calendar;
	}

	/**
	 * Méthode de conversion depuis une date SOAP
	 * 
	 * @param pGregory
	 * @return {@link Date}
	 */
	public Date convertirXMLGregorianCalendar(XMLGregorianCalendar pGregory) {
		Date maDate = pGregory.toGregorianCalendar().getTime();
		return maDate;
	}
}
