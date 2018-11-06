package fr.yogj.bibliows;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.5
 * 2018-10-31T13:59:06.184+01:00
 * Generated source version: 3.2.5
 *
 */
@WebService(targetNamespace = "http://yogj.fr/biblioWS/", name = "biblioWS")
@XmlSeeAlso({ObjectFactory.class, fr.yogj.bibliows.types.ObjectFactory.class})
public interface BiblioWS {

    @WebMethod
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "listRetardatairesResponse", targetNamespace = "http://yogj.fr/biblioWS/", partName = "parameters")
    public ListRetardatairesResponse listRetardataires(
        @WebParam(partName = "parameters", name = "listRetardataires", targetNamespace = "http://yogj.fr/biblioWS/")
        java.lang.String parameters
    );

    @WebMethod
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "listNouveautesResponse", targetNamespace = "http://yogj.fr/biblioWS/", partName = "parameters")
    public ListNouveautesResponse listNouveautes(
        @WebParam(partName = "parameters", name = "listNouveautes", targetNamespace = "http://yogj.fr/biblioWS/")
        java.lang.String parameters
    );

    @WebMethod
    @RequestWrapper(localName = "obtenirEmpruntUtilisateur", targetNamespace = "http://yogj.fr/biblioWS/", className = "fr.yogj.bibliows.ObtenirEmpruntUtilisateur")
    @ResponseWrapper(localName = "obtenirEmpruntUtilisateurResponse", targetNamespace = "http://yogj.fr/biblioWS/", className = "fr.yogj.bibliows.ObtenirEmpruntUtilisateurResponse")
    @WebResult(name = "livreEmprunt", targetNamespace = "")
    public java.util.List<fr.yogj.bibliows.types.LivreEmpruntType> obtenirEmpruntUtilisateur(
        @WebParam(name = "idUtilisateur", targetNamespace = "")
        int idUtilisateur
    ) throws ObtenirEmpruntUtilisateurFault_Exception;

    @WebMethod
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "rechercheOuvrageResponse", targetNamespace = "http://yogj.fr/biblioWS/", partName = "parameters")
    public RechercheOuvrageResponse rechercheOuvrage(
        @WebParam(partName = "parameters", name = "rechercheOuvrage", targetNamespace = "http://yogj.fr/biblioWS/")
        RechercheOuvrage parameters
    ) throws DetailsOuvrageFault_Exception;

    @WebMethod
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "deconnexionResponse", targetNamespace = "http://yogj.fr/biblioWS/", partName = "parameters")
    public java.lang.String deconnexion(
        @WebParam(partName = "parameters", name = "deconnexion", targetNamespace = "http://yogj.fr/biblioWS/")
        Deconnexion parameters
    ) throws DeconnexionFault_Exception;

    @WebMethod
    @RequestWrapper(localName = "empruntOuvrage", targetNamespace = "http://yogj.fr/biblioWS/", className = "fr.yogj.bibliows.EmpruntOuvrage")
    @ResponseWrapper(localName = "empruntOuvrageResponse", targetNamespace = "http://yogj.fr/biblioWS/", className = "fr.yogj.bibliows.EmpruntOuvrageResponse")
    @WebResult(name = "livre", targetNamespace = "")
    public fr.yogj.bibliows.types.LivreEmpruntType empruntOuvrage(
        @WebParam(name = "idLivre", targetNamespace = "")
        int idLivre,
        @WebParam(name = "idEmprunteur", targetNamespace = "")
        int idEmprunteur
    ) throws EmpruntOuvrageFault_Exception;

    @WebMethod
    @RequestWrapper(localName = "retourOuvrage", targetNamespace = "http://yogj.fr/biblioWS/", className = "fr.yogj.bibliows.RetourOuvrage")
    @ResponseWrapper(localName = "retourOuvrageResponse", targetNamespace = "http://yogj.fr/biblioWS/", className = "fr.yogj.bibliows.RetourOuvrageResponse")
    @WebResult(name = "livre", targetNamespace = "")
    public fr.yogj.bibliows.types.LivreType retourOuvrage(
        @WebParam(name = "idLivreEmprunt", targetNamespace = "")
        int idLivreEmprunt
    ) throws RetourOuvrageFault1_Exception;

    @WebMethod
    @RequestWrapper(localName = "prolongationOuvrage", targetNamespace = "http://yogj.fr/biblioWS/", className = "fr.yogj.bibliows.ProlongationOuvrage")
    @ResponseWrapper(localName = "prolongationOuvrageResponse", targetNamespace = "http://yogj.fr/biblioWS/", className = "fr.yogj.bibliows.ProlongationOuvrageResponse")
    @WebResult(name = "emprunt", targetNamespace = "")
    public fr.yogj.bibliows.types.LivreEmpruntType prolongationOuvrage(
        @WebParam(name = "idEmprunt", targetNamespace = "")
        int idEmprunt
    ) throws ProlongationOuvrageFault1_Exception;

    @WebMethod
    @RequestWrapper(localName = "login", targetNamespace = "http://yogj.fr/biblioWS/", className = "fr.yogj.bibliows.Login")
    @ResponseWrapper(localName = "loginResponse", targetNamespace = "http://yogj.fr/biblioWS/", className = "fr.yogj.bibliows.LoginResponse")
    @WebResult(name = "utilisateur", targetNamespace = "")
    public fr.yogj.bibliows.types.UtilisateurType login(
        @WebParam(name = "pseudo", targetNamespace = "")
        java.lang.String pseudo
    ) throws LoginFault_Exception;
}
