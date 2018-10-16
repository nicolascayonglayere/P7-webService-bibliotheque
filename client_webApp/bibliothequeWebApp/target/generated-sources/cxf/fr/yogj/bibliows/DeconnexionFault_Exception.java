
package fr.yogj.bibliows;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.5
 * 2018-10-16T08:59:56.636+02:00
 * Generated source version: 3.2.5
 */

@WebFault(name = "deconnexionFault", targetNamespace = "http://yogj.fr/biblioWS/")
public class DeconnexionFault_Exception extends Exception {

    private fr.yogj.bibliows.DeconnexionFault deconnexionFault;

    public DeconnexionFault_Exception() {
        super();
    }

    public DeconnexionFault_Exception(String message) {
        super(message);
    }

    public DeconnexionFault_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public DeconnexionFault_Exception(String message, fr.yogj.bibliows.DeconnexionFault deconnexionFault) {
        super(message);
        this.deconnexionFault = deconnexionFault;
    }

    public DeconnexionFault_Exception(String message, fr.yogj.bibliows.DeconnexionFault deconnexionFault, java.lang.Throwable cause) {
        super(message, cause);
        this.deconnexionFault = deconnexionFault;
    }

    public fr.yogj.bibliows.DeconnexionFault getFaultInfo() {
        return this.deconnexionFault;
    }
}
