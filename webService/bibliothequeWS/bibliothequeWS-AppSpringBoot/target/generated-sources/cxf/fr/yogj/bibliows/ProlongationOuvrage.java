
package fr.yogj.bibliows;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import fr.yogj.bibliows.types.Livre;
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
 *         &lt;choice&gt;
 *           &lt;element name="idEmprunt" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="dateEmprunt" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *             &lt;choice&gt;
 *               &lt;element name="idLivre" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *               &lt;element name="titre" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *               &lt;element name="ouvrage" type="{http://www.yogj.fr/biblioWS/types}Livre"/&gt;
 *             &lt;/choice&gt;
 *           &lt;/sequence&gt;
 *           &lt;element name="emprunt" type="{http://www.yogj.fr/biblioWS/types}LivreEmprunt"/&gt;
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
    "idEmprunt",
    "dateEmprunt",
    "idLivre",
    "titre",
    "ouvrage",
    "emprunt"
})
@XmlRootElement(name = "prolongationOuvrage")
public class ProlongationOuvrage {

    protected Integer idEmprunt;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateEmprunt;
    protected Integer idLivre;
    protected String titre;
    protected Livre ouvrage;
    protected LivreEmprunt emprunt;

    /**
     * Obtient la valeur de la propriété idEmprunt.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdEmprunt() {
        return idEmprunt;
    }

    /**
     * Définit la valeur de la propriété idEmprunt.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdEmprunt(Integer value) {
        this.idEmprunt = value;
    }

    /**
     * Obtient la valeur de la propriété dateEmprunt.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateEmprunt() {
        return dateEmprunt;
    }

    /**
     * Définit la valeur de la propriété dateEmprunt.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateEmprunt(XMLGregorianCalendar value) {
        this.dateEmprunt = value;
    }

    /**
     * Obtient la valeur de la propriété idLivre.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdLivre() {
        return idLivre;
    }

    /**
     * Définit la valeur de la propriété idLivre.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdLivre(Integer value) {
        this.idLivre = value;
    }

    /**
     * Obtient la valeur de la propriété titre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Définit la valeur de la propriété titre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitre(String value) {
        this.titre = value;
    }

    /**
     * Obtient la valeur de la propriété ouvrage.
     * 
     * @return
     *     possible object is
     *     {@link Livre }
     *     
     */
    public Livre getOuvrage() {
        return ouvrage;
    }

    /**
     * Définit la valeur de la propriété ouvrage.
     * 
     * @param value
     *     allowed object is
     *     {@link Livre }
     *     
     */
    public void setOuvrage(Livre value) {
        this.ouvrage = value;
    }

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
