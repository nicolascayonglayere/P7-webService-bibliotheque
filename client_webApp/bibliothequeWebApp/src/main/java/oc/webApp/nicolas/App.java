package oc.webApp.nicolas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Hello world!
 *
 */

@SpringBootApplication
// @EnableJaxRsWebClient
@ServletComponentScan
public class App {
	public static void main(String[] args) {

		System.out.println("Hello World!");
		SpringApplication.run(App.class, args);
	}

	// @Bean
	// CommandLineRunner initProxyClientRunner(final BiblioWS client) {
	//
	// return new CommandLineRunner() {
	//
	// @Override
	// public void run(String... runArgs) throws Exception {
	// System.out.println(client.listNouveautes(null));
	// }
	// };
	// }
	// @Bean
	// CommandLineRunner initWebClientRunner(final WebClient webClient) {
	// return new CommandLineRunner() {
	// @Override
	// public void run(String... runArgs) throws Exception {
	// System.out.println(webClient.path("biblioWS/BiblioWSWebClientUser").get(String.class));
	// }
	// };
	// }
}
