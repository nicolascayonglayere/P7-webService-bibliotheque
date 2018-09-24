
package fr.yogj.bibliows;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="dateDuJour" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *           &lt;element name="dateChoisie" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dateDuJour",
    "dateChoisie"
})
@XmlRootElement(name = "listNouveautes")
public class ListNouveautes {

    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateDuJour;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateChoisie;

    /**
     * Obtient la valeur de la propriété dateDuJour.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateDuJour() {
        return dateDuJour;
    }

    /**
     * Définit la valeur de la propriété dateDuJour.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateDuJour(XMLGregorianCalendar value) {
        this.dateDuJour = value;
    }

    /**
     * Obtient la valeur de la propriété dateChoisie.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateChoisie() {
        return dateChoisie;
    }

    /**
     * Définit la valeur de la propriété dateChoisie.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateChoisie(XMLGregorianCalendar value) {
        this.dateChoisie = value;
    }

}
