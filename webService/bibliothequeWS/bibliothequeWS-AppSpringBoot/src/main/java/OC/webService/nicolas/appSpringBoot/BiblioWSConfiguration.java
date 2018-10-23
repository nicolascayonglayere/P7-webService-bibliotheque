package OC.webService.nicolas.appSpringBoot;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.eclipse.jetty.io.EndPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;

import fr.yogj.bibliows.BiblioWS;

/**
 * Classe de configuration springBoot/cxf/sécurité avec wss4j
 * 
 * @author nicolas
 *
 */
@Configuration
@EnableWs
public class BiblioWSConfiguration extends WsConfigurerAdapter {

	/**
	 * Méthode pour obtenir le SpringBus
	 * 
	 * @return
	 */
	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus springBus() {
		return new SpringBus();
	}

	/**
	 * Méthode pour obtenir l'implémentation de {@link BiblioWS}
	 * 
	 * @return {@link BiblioWSEndPoint}
	 */
	@Bean
	public BiblioWS biblioService() {
		return new BiblioWSEndPoint();
	}

	/**
	 * Méthode pour configurer le {@link EndPoint}
	 * 
	 * @return
	 */
	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(this.springBus(), this.biblioService());
		endpoint.publish("/biblioWS");
		endpoint.setWsdlLocation("biblioWS.wsdl");
		// endpoint.getInInterceptors();
		return endpoint;
	}

	// @Bean
	// public SimplePasswordValidationCallbackHandler securityCallbackHandler() {
	// SimplePasswordValidationCallbackHandler callbackHandler = new
	// SimplePasswordValidationCallbackHandler();
	// Properties users = new Properties();
	// users.setProperty("admin", "secret");
	// callbackHandler.setUsers(users);
	// return callbackHandler;
	// }
	//
	// @Bean
	// public Wss4jSecurityInterceptor securityInterceptor() {
	// Wss4jSecurityInterceptor securityInterceptor = new
	// Wss4jSecurityInterceptor();
	// securityInterceptor.setValidationActions("Timestamp UsernameToken");
	// securityInterceptor.setValidationCallbackHandler(this.securityCallbackHandler());
	// return securityInterceptor;
	// }
	//
	// @Override
	// public void addInterceptors(List<EndpointInterceptor> interceptors) {
	// interceptors.add(this.securityInterceptor());
	// }
}
