
package fr.yogj.bibliows;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.5
 * 2018-12-05T13:29:38.418+01:00
 * Generated source version: 3.2.5
 */

@WebFault(name = "detailsOuvrageFault", targetNamespace = "http://yogj.fr/biblioWS/")
public class DetailsOuvrageFault_Exception extends Exception {

    private fr.yogj.bibliows.DetailsOuvrageFault detailsOuvrageFault;

    public DetailsOuvrageFault_Exception() {
        super();
    }

    public DetailsOuvrageFault_Exception(String message) {
        super(message);
    }

    public DetailsOuvrageFault_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public DetailsOuvrageFault_Exception(String message, fr.yogj.bibliows.DetailsOuvrageFault detailsOuvrageFault) {
        super(message);
        this.detailsOuvrageFault = detailsOuvrageFault;
    }

    public DetailsOuvrageFault_Exception(String message, fr.yogj.bibliows.DetailsOuvrageFault detailsOuvrageFault, java.lang.Throwable cause) {
        super(message, cause);
        this.detailsOuvrageFault = detailsOuvrageFault;
    }

    public fr.yogj.bibliows.DetailsOuvrageFault getFaultInfo() {
        return this.detailsOuvrageFault;
    }
}
