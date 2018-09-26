package OC.webService.nicolas.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import OC.webService.nicolas.model.App;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class);
        System.out.println( "Hello World!" );
    }
}
