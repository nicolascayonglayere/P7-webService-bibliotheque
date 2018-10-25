
package fr.yogj.bibliows;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.5
 * 2018-10-25T14:21:26.196+02:00
 * Generated source version: 3.2.5
 */

@WebFault(name = "empruntOuvrageFault", targetNamespace = "http://yogj.fr/biblioWS/")
public class EmpruntOuvrageFault_Exception extends Exception {

    private fr.yogj.bibliows.EmpruntOuvrageFault empruntOuvrageFault;

    public EmpruntOuvrageFault_Exception() {
        super();
    }

    public EmpruntOuvrageFault_Exception(String message) {
        super(message);
    }

    public EmpruntOuvrageFault_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public EmpruntOuvrageFault_Exception(String message, fr.yogj.bibliows.EmpruntOuvrageFault empruntOuvrageFault) {
        super(message);
        this.empruntOuvrageFault = empruntOuvrageFault;
    }

    public EmpruntOuvrageFault_Exception(String message, fr.yogj.bibliows.EmpruntOuvrageFault empruntOuvrageFault, java.lang.Throwable cause) {
        super(message, cause);
        this.empruntOuvrageFault = empruntOuvrageFault;
    }

    public fr.yogj.bibliows.EmpruntOuvrageFault getFaultInfo() {
        return this.empruntOuvrageFault;
    }
}
