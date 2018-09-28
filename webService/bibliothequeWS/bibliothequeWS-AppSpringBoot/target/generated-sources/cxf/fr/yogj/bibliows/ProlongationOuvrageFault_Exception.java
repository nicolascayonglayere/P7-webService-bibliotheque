
package fr.yogj.bibliows;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.5
 * 2018-09-28T15:57:02.156+02:00
 * Generated source version: 3.2.5
 */

@WebFault(name = "prolongationOuvrageFault", targetNamespace = "http://yogj.fr/biblioWS/")
public class ProlongationOuvrageFault_Exception extends Exception {

    private fr.yogj.bibliows.ProlongationOuvrageFault prolongationOuvrageFault;

    public ProlongationOuvrageFault_Exception() {
        super();
    }

    public ProlongationOuvrageFault_Exception(String message) {
        super(message);
    }

    public ProlongationOuvrageFault_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public ProlongationOuvrageFault_Exception(String message, fr.yogj.bibliows.ProlongationOuvrageFault prolongationOuvrageFault) {
        super(message);
        this.prolongationOuvrageFault = prolongationOuvrageFault;
    }

    public ProlongationOuvrageFault_Exception(String message, fr.yogj.bibliows.ProlongationOuvrageFault prolongationOuvrageFault, java.lang.Throwable cause) {
        super(message, cause);
        this.prolongationOuvrageFault = prolongationOuvrageFault;
    }

    public fr.yogj.bibliows.ProlongationOuvrageFault getFaultInfo() {
        return this.prolongationOuvrageFault;
    }
}
