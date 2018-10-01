
package fr.yogj.bibliows;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.5
 * 2018-10-01T14:04:36.439+02:00
 * Generated source version: 3.2.5
 */

@WebFault(name = "retourOuvrageFault", targetNamespace = "http://yogj.fr/biblioWS/")
public class RetourOuvrageFault_Exception extends Exception {

    private fr.yogj.bibliows.RetourOuvrageFault retourOuvrageFault;

    public RetourOuvrageFault_Exception() {
        super();
    }

    public RetourOuvrageFault_Exception(String message) {
        super(message);
    }

    public RetourOuvrageFault_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public RetourOuvrageFault_Exception(String message, fr.yogj.bibliows.RetourOuvrageFault retourOuvrageFault) {
        super(message);
        this.retourOuvrageFault = retourOuvrageFault;
    }

    public RetourOuvrageFault_Exception(String message, fr.yogj.bibliows.RetourOuvrageFault retourOuvrageFault, java.lang.Throwable cause) {
        super(message, cause);
        this.retourOuvrageFault = retourOuvrageFault;
    }

    public fr.yogj.bibliows.RetourOuvrageFault getFaultInfo() {
        return this.retourOuvrageFault;
    }
}