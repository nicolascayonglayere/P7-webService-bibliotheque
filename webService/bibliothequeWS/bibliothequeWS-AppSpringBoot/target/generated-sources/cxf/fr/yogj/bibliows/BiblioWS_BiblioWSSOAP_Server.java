
package fr.yogj.bibliows;

import javax.xml.ws.Endpoint;

/**
 * This class was generated by Apache CXF 3.2.5
 * 2018-10-15T10:23:06.732+02:00
 * Generated source version: 3.2.5
 *
 */

public class BiblioWS_BiblioWSSOAP_Server{

    protected BiblioWS_BiblioWSSOAP_Server() throws java.lang.Exception {
        System.out.println("Starting Server");
        Object implementor = new BiblioWSSOAPImpl();
        String address = "http://localhost:8181/biblioWS";
        Endpoint.publish(address, implementor);
    }

    public static void main(String args[]) throws java.lang.Exception {
        new BiblioWS_BiblioWSSOAP_Server();
        System.out.println("Server ready...");

        Thread.sleep(5 * 60 * 1000);
        System.out.println("Server exiting");
        System.exit(0);
    }
}
