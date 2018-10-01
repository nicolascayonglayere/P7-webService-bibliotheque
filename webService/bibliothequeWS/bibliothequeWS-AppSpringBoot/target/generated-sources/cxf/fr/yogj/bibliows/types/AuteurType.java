
package fr.yogj.bibliows.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour AuteurType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="AuteurType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="prenom" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="dateDeNaissance" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="nationalite" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="manuscrits" type="{http://www.yogj.fr/biblioWS/types}LivreType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuteurType", propOrder = {
    "id",
    "nom",
    "prenom",
    "dateDeNaissance",
    "nationalite",
    "manuscrits"
})
public class AuteurType {

    protected int id;
    protected List<String> nom;
    protected List<String> prenom;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateDeNaissance;
    @XmlElement(required = true)
    protected String nationalite;
    @XmlElement(required = true)
    protected List<LivreType> manuscrits;

    /**
     * Obtient la valeur de la propriété id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the nom property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nom property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNom().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getNom() {
        if (nom == null) {
            nom = new ArrayList<String>();
        }
        return this.nom;
    }

    /**
     * Gets the value of the prenom property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the prenom property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrenom().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPrenom() {
        if (prenom == null) {
            prenom = new ArrayList<String>();
        }
        return this.prenom;
    }

    /**
     * Obtient la valeur de la propriété dateDeNaissance.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateDeNaissance() {
        return dateDeNaissance;
    }

    /**
     * Définit la valeur de la propriété dateDeNaissance.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateDeNaissance(XMLGregorianCalendar value) {
        this.dateDeNaissance = value;
    }

    /**
     * Obtient la valeur de la propriété nationalite.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNationalite() {
        return nationalite;
    }

    /**
     * Définit la valeur de la propriété nationalite.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNationalite(String value) {
        this.nationalite = value;
    }

    /**
     * Gets the value of the manuscrits property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the manuscrits property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getManuscrits().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LivreType }
     * 
     * 
     */
    public List<LivreType> getManuscrits() {
        if (manuscrits == null) {
            manuscrits = new ArrayList<LivreType>();
        }
        return this.manuscrits;
    }

}