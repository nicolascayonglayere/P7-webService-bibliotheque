
package fr.yogj.bibliows;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
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
 *         &lt;element name="emprunt" type="{http://www.yogj.fr/biblioWS/types}LivreEmprunt"/&gt;
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
    "emprunt"
})
@XmlRootElement(name = "prolongationOuvrageResponse")
public class ProlongationOuvrageResponse {

    @XmlElement(required = true)
    protected LivreEmprunt emprunt;

    /**
     * Obtient la valeur de la propriété emprunt.
     * 
     * @return
     *     possible object is
     *     {@link LivreEmprunt }
     *     
     */
    public LivreEmprunt getEmprunt() {
        return emprunt;
    }

    /**
     * Définit la valeur de la propriété emprunt.
     * 
     * @param value
     *     allowed object is
     *     {@link LivreEmprunt }
     *     
     */
    public void setEmprunt(LivreEmprunt value) {
        this.emprunt = value;
    }

}
