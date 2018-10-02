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
 * 2018-10-02T15:14:39.585+02:00
 * Generated source version: 3.2.5
 *
 */
@WebService(targetNamespace = "http://yogj.fr/biblioWS/", name = "biblioWS")
@XmlSeeAlso({ObjectFactory.class, fr.yogj.bibliows.types.ObjectFactory.class})
public interface BiblioWS {

    @WebMethod(action = "http://yogj.fr/biblioWS/listRetardataires")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "listRetardatairesResponse", targetNamespace = "http://yogj.fr/biblioWS/", partName = "parameters")
    public ListRetardatairesResponse listRetardataires(
        @WebParam(partName = "parameters", name = "listRetardataires", targetNamespace = "http://yogj.fr/biblioWS/")
        java.lang.String parameters
    );

    @WebMethod(action = "http://yogj.fr/biblioWS/listNouveautes")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "listNouveautesResponse", targetNamespace = "http://yogj.fr/biblioWS/", partName = "parameters")
    public ListNouveautesResponse listNouveautes(
        @WebParam(partName = "parameters", name = "listNouveautes", targetNamespace = "http://yogj.fr/biblioWS/")
        java.lang.String parameters
    );

    @WebMethod(action = "http://yogj.fr/biblioWS/rechercheOuvrage")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "rechercheOuvrageResponse", targetNamespace = "http://yogj.fr/biblioWS/", partName = "parameters")
    public RechercheOuvrageResponse rechercheOuvrage(
        @WebParam(partName = "parameters", name = "rechercheOuvrage", targetNamespace = "http://yogj.fr/biblioWS/")
        RechercheOuvrage parameters
    ) throws DetailsOuvrageFault_Exception;

    @WebMethod(action = "http://yogj.fr/biblioWS/deconnexion")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "deconnexionResponse", targetNamespace = "http://yogj.fr/biblioWS/", partName = "parameters")
    public java.lang.String deconnexion(
        @WebParam(partName = "parameters", name = "deconnexion", targetNamespace = "http://yogj.fr/biblioWS/")
        Deconnexion parameters
    ) throws DeconnexionFault_Exception;

    @WebMethod(action = "http://yogj.fr/biblioWS/empruntOuvrage")
    @RequestWrapper(localName = "empruntOuvrage", targetNamespace = "http://yogj.fr/biblioWS/", className = "fr.yogj.bibliows.EmpruntOuvrage")
    @ResponseWrapper(localName = "empruntOuvrageResponse", targetNamespace = "http://yogj.fr/biblioWS/", className = "fr.yogj.bibliows.EmpruntOuvrageResponse")
    @WebResult(name = "livre", targetNamespace = "")
    public fr.yogj.bibliows.types.LivreEmpruntType empruntOuvrage(
        @WebParam(name = "idLivre", targetNamespace = "")
        int idLivre,
        @WebParam(name = "idEmprunteur", targetNamespace = "")
        int idEmprunteur
    ) throws EmpruntOuvrageFault_Exception;

    @WebMethod(action = "http://yogj.fr/biblioWS/retourOuvrage")
    @RequestWrapper(localName = "retourOuvrage", targetNamespace = "http://yogj.fr/biblioWS/", className = "fr.yogj.bibliows.RetourOuvrage")
    @ResponseWrapper(localName = "retourOuvrageResponse", targetNamespace = "http://yogj.fr/biblioWS/", className = "fr.yogj.bibliows.RetourOuvrageResponse")
    @WebResult(name = "livre", targetNamespace = "")
    public fr.yogj.bibliows.types.LivreType retourOuvrage(
        @WebParam(name = "id", targetNamespace = "")
        int id,
        @WebParam(name = "idEmprunteur", targetNamespace = "")
        int idEmprunteur
    ) throws RetourOuvrageFault_Exception, RetourOuvrageFault1_Exception;

    @WebMethod(action = "http://yogj.fr/biblioWS/prolongationOuvrage")
    @RequestWrapper(localName = "prolongationOuvrage", targetNamespace = "http://yogj.fr/biblioWS/", className = "fr.yogj.bibliows.ProlongationOuvrage")
    @ResponseWrapper(localName = "prolongationOuvrageResponse", targetNamespace = "http://yogj.fr/biblioWS/", className = "fr.yogj.bibliows.ProlongationOuvrageResponse")
    @WebResult(name = "emprunt", targetNamespace = "")
    public fr.yogj.bibliows.types.LivreEmpruntType prolongationOuvrage(
        @WebParam(name = "idEmprunt", targetNamespace = "")
        int idEmprunt
    ) throws ProlongationOuvrageFault_Exception, ProlongationOuvrageFault1_Exception;

    @WebMethod(action = "http://yogj.fr/biblioWS/login")
    @RequestWrapper(localName = "login", targetNamespace = "http://yogj.fr/biblioWS/", className = "fr.yogj.bibliows.Login")
    @ResponseWrapper(localName = "loginResponse", targetNamespace = "http://yogj.fr/biblioWS/", className = "fr.yogj.bibliows.LoginResponse")
    @WebResult(name = "utilisateur", targetNamespace = "")
    public fr.yogj.bibliows.types.UtilisateurType login(
        @WebParam(name = "pseudo", targetNamespace = "")
        java.lang.String pseudo,
        @WebParam(name = "motDePasse", targetNamespace = "")
        java.lang.String motDePasse
    ) throws LoginFault_Exception;
}
