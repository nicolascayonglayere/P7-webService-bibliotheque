package oc.webApp.nicolas;

import java.util.Collections;


import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxrs.client.spring.JaxRsProxyClientConfiguration;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.yogj.bibliows.BiblioWS;
import fr.yogj.bibliows.BiblioWS_Service;


@Configuration
//@ConfigurationProperties(prefix = "cxf")
public class BiblioWebAppConfiguration extends JaxRsProxyClientConfiguration {
	
    @Override
    protected Class<?> getServiceClass() {
        return BiblioWS.class;
    }

	//@Value("${cxf.jaxrs.client.address}")
	//private String serverUrl;
    //
	//public void setServerUrl(String serverUrl) {
	//	this.serverUrl = serverUrl;
	//}
    //
	//@Bean
	//public BiblioWS bus(SpringBus bus) {
	//	JaxWsProxyFactoryBean bean = new JaxWsProxyFactoryBean();
	//	bean.setServiceClass(BiblioWS.class);
	//	bean.setAddress(serverUrl);
	//	bean.setBus(bus);
	//	//bean.setFeatures(Collections.singletonList(new LoggingFeature()));
	//	return bean.create(BiblioWS.class);
	//}
}
