
package fr.yogj.bibliows;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.5
 * 2018-10-23T15:47:19.913+02:00
 * Generated source version: 3.2.5
 */

@WebFault(name = "prolongationOuvrageFault1", targetNamespace = "http://yogj.fr/biblioWS/")
public class ProlongationOuvrageFault1_Exception extends Exception {

    private fr.yogj.bibliows.ProlongationOuvrageFault1 prolongationOuvrageFault1;

    public ProlongationOuvrageFault1_Exception() {
        super();
    }

    public ProlongationOuvrageFault1_Exception(String message) {
        super(message);
    }

    public ProlongationOuvrageFault1_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public ProlongationOuvrageFault1_Exception(String message, fr.yogj.bibliows.ProlongationOuvrageFault1 prolongationOuvrageFault1) {
        super(message);
        this.prolongationOuvrageFault1 = prolongationOuvrageFault1;
    }

    public ProlongationOuvrageFault1_Exception(String message, fr.yogj.bibliows.ProlongationOuvrageFault1 prolongationOuvrageFault1, java.lang.Throwable cause) {
        super(message, cause);
        this.prolongationOuvrageFault1 = prolongationOuvrageFault1;
    }

    public fr.yogj.bibliows.ProlongationOuvrageFault1 getFaultInfo() {
        return this.prolongationOuvrageFault1;
    }
}
