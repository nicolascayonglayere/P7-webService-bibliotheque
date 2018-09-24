
package fr.yogj.bibliows;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import fr.yogj.bibliows.types.LivreEmprunt;


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
 *         &lt;element name="livre" type="{http://www.yogj.fr/biblioWS/types}LivreEmprunt"/&gt;
 *         &lt;element name="dateRetour" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
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
    "livre",
    "dateRetour"
})
@XmlRootElement(name = "empruntOuvrageResponse")
public class EmpruntOuvrageResponse {

    @XmlElement(required = true)
    protected LivreEmprunt livre;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateRetour;

    /**
     * Obtient la valeur de la propriété livre.
     * 
     * @return
     *     possible object is
     *     {@link LivreEmprunt }
     *     
     */
    public LivreEmprunt getLivre() {
        return livre;
    }

    /**
     * Définit la valeur de la propriété livre.
     * 
     * @param value
     *     allowed object is
     *     {@link LivreEmprunt }
     *     
     */
    public void setLivre(LivreEmprunt value) {
        this.livre = value;
    }

    /**
     * Obtient la valeur de la propriété dateRetour.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateRetour() {
        return dateRetour;
    }

    /**
     * Définit la valeur de la propriété dateRetour.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateRetour(XMLGregorianCalendar value) {
        this.dateRetour = value;
    }

}
