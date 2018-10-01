
package fr.yogj.bibliows;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;choice&gt;
 *           &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *           &lt;element name="titre" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *           &lt;element name="genre" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *           &lt;element name="auteurId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *           &lt;element name="auteurNom" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "id",
    "titre",
    "genre",
    "auteurId",
    "auteurNom"
})
@XmlRootElement(name = "rechercheOuvrage")
public class RechercheOuvrage {

    protected Integer id;
    protected String titre;
    protected String genre;
    protected Integer auteurId;
    protected String auteurNom;

    /**
     * Obtient la valeur de la propriété id.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
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
     * Obtient la valeur de la propriété genre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Définit la valeur de la propriété genre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenre(String value) {
        this.genre = value;
    }

    /**
     * Obtient la valeur de la propriété auteurId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAuteurId() {
        return auteurId;
    }

    /**
     * Définit la valeur de la propriété auteurId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAuteurId(Integer value) {
        this.auteurId = value;
    }

    /**
     * Obtient la valeur de la propriété auteurNom.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuteurNom() {
        return auteurNom;
    }

    /**
     * Définit la valeur de la propriété auteurNom.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuteurNom(String value) {
        this.auteurNom = value;
    }

}
