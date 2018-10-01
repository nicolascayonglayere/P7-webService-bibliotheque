package OC.webService.nicolas.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import OC.webService.nicolas.model.App;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages={"OC.webService.nicolas.model.entites"})
@EnableAutoConfiguration
@EntityScan(basePackages="OC.webService.nicolas.model.entites")
public class App
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class);
        System.out.println( "Hello World!" );
    }
}
