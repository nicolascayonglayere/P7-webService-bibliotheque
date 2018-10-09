
package fr.yogj.bibliows;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
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
 * 2018-10-09T10:44:15.713+02:00
 * Generated source version: 3.2.5
 *
 */
public final class BiblioWS_BiblioWSSOAP_Client {

    private static final QName SERVICE_NAME = new QName("http://yogj.fr/biblioWS/", "biblioWS");

    private BiblioWS_BiblioWSSOAP_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = BiblioWS_Service.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        BiblioWS_Service ss = new BiblioWS_Service(wsdlURL, SERVICE_NAME);
        BiblioWS port = ss.getBiblioWSSOAP();

        {
        System.out.println("Invoking listRetardataires...");
        java.lang.String _listRetardataires_parameters = "";
        fr.yogj.bibliows.ListRetardatairesResponse _listRetardataires__return = port.listRetardataires(_listRetardataires_parameters);
        System.out.println("listRetardataires.result=" + _listRetardataires__return);


        }
        {
        System.out.println("Invoking listNouveautes...");
        java.lang.String _listNouveautes_parameters = "";
        fr.yogj.bibliows.ListNouveautesResponse _listNouveautes__return = port.listNouveautes(_listNouveautes_parameters);
        System.out.println("listNouveautes.result=" + _listNouveautes__return);


        }
        {
        System.out.println("Invoking obtenirEmpruntUtilisateur...");
        int _obtenirEmpruntUtilisateur_idUtilisateur = 0;
        try {
            java.util.List<fr.yogj.bibliows.types.LivreEmpruntType> _obtenirEmpruntUtilisateur__return = port.obtenirEmpruntUtilisateur(_obtenirEmpruntUtilisateur_idUtilisateur);
            System.out.println("obtenirEmpruntUtilisateur.result=" + _obtenirEmpruntUtilisateur__return);

        } catch (ObtenirEmpruntUtilisateurFault_Exception e) {
            System.out.println("Expected exception: obtenirEmpruntUtilisateurFault has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking rechercheOuvrage...");
        fr.yogj.bibliows.RechercheOuvrage _rechercheOuvrage_parameters = null;
        try {
            fr.yogj.bibliows.RechercheOuvrageResponse _rechercheOuvrage__return = port.rechercheOuvrage(_rechercheOuvrage_parameters);
            System.out.println("rechercheOuvrage.result=" + _rechercheOuvrage__return);

        } catch (DetailsOuvrageFault_Exception e) {
            System.out.println("Expected exception: detailsOuvrageFault has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking deconnexion...");
        fr.yogj.bibliows.Deconnexion _deconnexion_parameters = null;
        try {
            java.lang.String _deconnexion__return = port.deconnexion(_deconnexion_parameters);
            System.out.println("deconnexion.result=" + _deconnexion__return);

        } catch (DeconnexionFault_Exception e) {
            System.out.println("Expected exception: deconnexionFault has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking empruntOuvrage...");
        int _empruntOuvrage_idLivre = 0;
        int _empruntOuvrage_idEmprunteur = 0;
        try {
            fr.yogj.bibliows.types.LivreEmpruntType _empruntOuvrage__return = port.empruntOuvrage(_empruntOuvrage_idLivre, _empruntOuvrage_idEmprunteur);
            System.out.println("empruntOuvrage.result=" + _empruntOuvrage__return);

        } catch (EmpruntOuvrageFault_Exception e) {
            System.out.println("Expected exception: empruntOuvrageFault has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking retourOuvrage...");
        int _retourOuvrage_idLivreEmprunt = 0;
        try {
            fr.yogj.bibliows.types.LivreType _retourOuvrage__return = port.retourOuvrage(_retourOuvrage_idLivreEmprunt);
            System.out.println("retourOuvrage.result=" + _retourOuvrage__return);

        } catch (RetourOuvrageFault1_Exception e) {
            System.out.println("Expected exception: retourOuvrageFault1 has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking prolongationOuvrage...");
        int _prolongationOuvrage_idEmprunt = 0;
        try {
            fr.yogj.bibliows.types.LivreEmpruntType _prolongationOuvrage__return = port.prolongationOuvrage(_prolongationOuvrage_idEmprunt);
            System.out.println("prolongationOuvrage.result=" + _prolongationOuvrage__return);

        } catch (ProlongationOuvrageFault1_Exception e) {
            System.out.println("Expected exception: prolongationOuvrageFault1 has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking login...");
        java.lang.String _login_pseudo = "";
        java.lang.String _login_motDePasse = "";
        try {
            fr.yogj.bibliows.types.UtilisateurType _login__return = port.login(_login_pseudo, _login_motDePasse);
            System.out.println("login.result=" + _login__return);

        } catch (LoginFault_Exception e) {
            System.out.println("Expected exception: loginFault has occurred.");
            System.out.println(e.toString());
        }
            }

        System.exit(0);
    }

}
