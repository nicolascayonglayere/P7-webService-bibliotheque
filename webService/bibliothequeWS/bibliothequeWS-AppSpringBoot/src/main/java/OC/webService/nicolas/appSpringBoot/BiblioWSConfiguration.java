package OC.webService.nicolas.appSpringBoot;

import java.util.List;
import java.util.Properties;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;
import org.springframework.ws.soap.security.wss4j2.callback.SimplePasswordValidationCallbackHandler;

import fr.yogj.bibliows.BiblioWS;

@Configuration
@EnableWs
public class BiblioWSConfiguration extends WsConfigurerAdapter{

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
    
    @Bean
    public SimplePasswordValidationCallbackHandler securityCallbackHandler(){
        SimplePasswordValidationCallbackHandler callbackHandler = new SimplePasswordValidationCallbackHandler();
        Properties users = new Properties();
        users.setProperty("admin", "secret");
        callbackHandler.setUsers(users);
        return callbackHandler;
    }

    @Bean
    public Wss4jSecurityInterceptor securityInterceptor(){
        Wss4jSecurityInterceptor securityInterceptor = new Wss4jSecurityInterceptor();
        securityInterceptor.setValidationActions("Timestamp UsernameToken");
        securityInterceptor.setValidationCallbackHandler(securityCallbackHandler());
        return securityInterceptor;
    }

    @Override
    public void addInterceptors(List interceptors) {
        interceptors.add(securityInterceptor());
    }
}
