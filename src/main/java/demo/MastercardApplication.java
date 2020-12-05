package demo;



import java.io.IOException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.component.ConnectComponent;


@SpringBootApplication
@ComponentScan(basePackages = "com.example.*")
public class MastercardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MastercardApplication.class, args);
	}
	
	/**
	 * @param connectComponent
	 * @return
	 * 
	 * On application startup, the cities is loaded by reading thew file.
	 */
	@Bean
    public CommandLineRunner runOnStartup(final ConnectComponent connectComponent) {
        return (args) -> {
            try {
            	connectComponent.buildConnect();
            } catch (IOException ioe) {
                throw ioe;
            }
        };
    }
	
}
