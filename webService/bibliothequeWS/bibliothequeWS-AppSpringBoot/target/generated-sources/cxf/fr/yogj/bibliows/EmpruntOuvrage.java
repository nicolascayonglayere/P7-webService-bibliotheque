
package fr.yogj.bibliows;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import fr.yogj.bibliows.types.LivreType;
import fr.yogj.bibliows.types.UtilisateurType;


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
 *           &lt;element name="ouvrage" type="{http://www.yogj.fr/biblioWS/types}LivreType"/&gt;
 *         &lt;/choice&gt;
 *         &lt;choice&gt;
 *           &lt;element name="idEmprunteur" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *           &lt;element name="pseudo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *           &lt;element name="utilisateur" type="{http://www.yogj.fr/biblioWS/types}UtilisateurType"/&gt;
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
    "ouvrage",
    "idEmprunteur",
    "pseudo",
    "utilisateur"
})
@XmlRootElement(name = "empruntOuvrage")
public class EmpruntOuvrage {

    protected Integer id;
    protected String titre;
    protected LivreType ouvrage;
    protected Integer idEmprunteur;
    protected String pseudo;
    protected UtilisateurType utilisateur;

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
     * Obtient la valeur de la propriété ouvrage.
     * 
     * @return
     *     possible object is
     *     {@link LivreType }
     *     
     */
    public LivreType getOuvrage() {
        return ouvrage;
    }

    /**
     * Définit la valeur de la propriété ouvrage.
     * 
     * @param value
     *     allowed object is
     *     {@link LivreType }
     *     
     */
    public void setOuvrage(LivreType value) {
        this.ouvrage = value;
    }

    /**
     * Obtient la valeur de la propriété idEmprunteur.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdEmprunteur() {
        return idEmprunteur;
    }

    /**
     * Définit la valeur de la propriété idEmprunteur.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdEmprunteur(Integer value) {
        this.idEmprunteur = value;
    }

    /**
     * Obtient la valeur de la propriété pseudo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * Définit la valeur de la propriété pseudo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPseudo(String value) {
        this.pseudo = value;
    }

    /**
     * Obtient la valeur de la propriété utilisateur.
     * 
     * @return
     *     possible object is
     *     {@link UtilisateurType }
     *     
     */
    public UtilisateurType getUtilisateur() {
        return utilisateur;
    }

    /**
     * Définit la valeur de la propriété utilisateur.
     * 
     * @param value
     *     allowed object is
     *     {@link UtilisateurType }
     *     
     */
    public void setUtilisateur(UtilisateurType value) {
        this.utilisateur = value;
    }

}
