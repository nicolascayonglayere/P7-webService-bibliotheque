
package fr.yogj.bibliows;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.5
 * 2018-10-31T13:59:06.159+01:00
 * Generated source version: 3.2.5
 */

@WebFault(name = "retourOuvrageFault1", targetNamespace = "http://yogj.fr/biblioWS/")
public class RetourOuvrageFault1_Exception extends Exception {

    private fr.yogj.bibliows.RetourOuvrageFault1 retourOuvrageFault1;

    public RetourOuvrageFault1_Exception() {
        super();
    }

    public RetourOuvrageFault1_Exception(String message) {
        super(message);
    }

    public RetourOuvrageFault1_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public RetourOuvrageFault1_Exception(String message, fr.yogj.bibliows.RetourOuvrageFault1 retourOuvrageFault1) {
        super(message);
        this.retourOuvrageFault1 = retourOuvrageFault1;
    }

    public RetourOuvrageFault1_Exception(String message, fr.yogj.bibliows.RetourOuvrageFault1 retourOuvrageFault1, java.lang.Throwable cause) {
        super(message, cause);
        this.retourOuvrageFault1 = retourOuvrageFault1;
    }

    public fr.yogj.bibliows.RetourOuvrageFault1 getFaultInfo() {
        return this.retourOuvrageFault1;
    }
}