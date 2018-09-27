package OC.webService.nicolas.appSpringBoot;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;

import fr.yogj.bibliows.BiblioWS;

@Configuration
@EnableWs
public class BiblioWSConfiguration {

    @Bean(name=Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {      
        return new SpringBus();
    } 

    @Bean
    public BiblioWS biblioService() {
    	return new BiblioWSEndPoint();
    }
    
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), biblioService());
        endpoint.publish("/biblioWS");
        endpoint.setWsdlLocation("biblioWS.wsdl");
        return endpoint;
    }
}
