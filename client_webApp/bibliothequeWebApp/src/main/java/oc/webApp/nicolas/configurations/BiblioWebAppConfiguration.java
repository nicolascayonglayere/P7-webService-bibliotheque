package oc.webApp.nicolas.configurations;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import fr.yogj.bibliows.BiblioWS;

@Configuration
@ConfigurationProperties(prefix = "cxf")
public class BiblioWebAppConfiguration { // {extends JaxRsProxyClientConfiguration {

	/**
	 * Méthode pour obtenir le SpringBus
	 * 
	 * @return
	 */
	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus springBus() {
		return new SpringBus();
	}

	static final Logger logger = LogManager.getLogger();
	@Value("${biblio.ws.endpoint-url}")
	private String url;

	@Value("${biblio.ws.key-store}")
	private Resource keyStore;

	@Value("${biblio.ws.key-store-password}")
	private String keyStorePassword;

	@Value("${biblio.ws.trust-store}")
	private Resource trustStore;

	@Value("${biblio.ws.trust-store-password}")
	private String trustStorePassword;

	@Bean
	public BiblioWS bus(SpringBus bus) {
		JaxWsProxyFactoryBean bean = new JaxWsProxyFactoryBean();
		bean.setServiceClass(BiblioWS.class);
		bean.setAddress(this.url);
		bean.setBus(bus);

		// KeyStore ks;
		// try {
		// ks = KeyStore.getInstance("JKS");
		//
		// ks.load(this.keyStore.getInputStream(), this.keyStorePassword.toCharArray());
		//
		// logger.info("Loaded keystore: " + this.keyStore.getURI().toString());
		// try {
		// this.keyStore.getInputStream().close();
		// } catch (IOException e) {
		// }
		// KeyManagerFactory keyManagerFactory = KeyManagerFactory
		// .getInstance(KeyManagerFactory.getDefaultAlgorithm());
		// keyManagerFactory.init(ks, this.keyStorePassword.toCharArray());
		//
		// KeyStore ts = KeyStore.getInstance("JKS");
		// ts.load(this.trustStore.getInputStream(),
		// this.trustStorePassword.toCharArray());
		// logger.info("Loaded trustStore: " + this.trustStore.getURI().toString());
		// try {
		// this.trustStore.getInputStream().close();
		// } catch (IOException e) {
		// }
		// TrustManagerFactory trustManagerFactory = TrustManagerFactory
		// .getInstance(TrustManagerFactory.getDefaultAlgorithm());
		// trustManagerFactory.init(ts);
		//
		// HttpsUrlConnectionMessageSender messageSender = new
		// HttpsUrlConnectionMessageSender();
		// messageSender.setKeyManagers(keyManagerFactory.getKeyManagers());
		// messageSender.setTrustManagers(trustManagerFactory.getTrustManagers());
		//
		// // otherwise: java.security.cert.CertificateException: No name matching
		// // localhost found
		// messageSender.setHostnameVerifier((hostname, sslSession) -> {
		// if (hostname.equals("localhost")) {
		// return true;
		// }
		// return false;
		// });
		//
		// bean.setConduitSelector((ConduitSelector) messageSender);
		// // bean.setFeatures(Collections.singletonList(new LoggingFeature()));
		//
		// } catch (KeyStoreException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// } catch (NoSuchAlgorithmException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// } catch (CertificateException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// } catch (IOException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// } catch (UnrecoverableKeyException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		return bean.create(BiblioWS.class);
	}

	// @Bean
	// public WebServerFactoryCustomizer<UndertowServletWebServerFactory>
	// containerCustomizer() {
	// return (WebServerFactoryCustomizer) factory -> {
	// UndertowServletWebServerFactory undertowFactory =
	// (UndertowServletWebServerFactory) factory;
	// undertowFactory.getBuilderCustomizers().add(builder -> {
	// builder.addHttpListener(httpPort, httpInterface);
	// });
	// };
	// }
	@Bean
	public FilterRegistrationBean<Filter> someFilterRegistration() {
		FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<Filter>();
		registration.setFilter(new StrutsPrepareAndExecuteFilter());
		registration.addUrlPatterns("*.action");
		registration.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.FORWARD);
		registration.setName("StrutsPrepareAndExecuteFilter");
		return registration;
	}
}
