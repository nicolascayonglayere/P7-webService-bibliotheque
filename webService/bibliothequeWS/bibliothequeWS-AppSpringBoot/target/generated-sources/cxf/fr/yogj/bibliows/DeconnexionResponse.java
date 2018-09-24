
package fr.yogj.bibliows;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="messageDeconnexion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "messageDeconnexion"
})
@XmlRootElement(name = "deconnexionResponse")
public class DeconnexionResponse {

    @XmlElement(required = true)
    protected String messageDeconnexion;

    /**
     * Obtient la valeur de la propriété messageDeconnexion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageDeconnexion() {
        return messageDeconnexion;
    }

    /**
     * Définit la valeur de la propriété messageDeconnexion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageDeconnexion(String value) {
        this.messageDeconnexion = value;
    }

}
