package OC.webService.nicolas.appSpringBoot.helpers;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Component;

@Component
public class ConversionDate {
	
	public ConversionDate() {}
	
	public XMLGregorianCalendar convertirDateXML(Date pDate) throws DatatypeConfigurationException {
		GregorianCalendar gregory = new GregorianCalendar();
		gregory.setTime(pDate);
		XMLGregorianCalendar calendar;

		calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory);

		return calendar;
	}
	
	public Date convertirXMLGregorianCalendar(XMLGregorianCalendar pGregory) {
		Date maDate = pGregory.toGregorianCalendar().getTime();
		return maDate;
	}
}

