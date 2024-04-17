package blog.ismoil.zaripovs.infrastructure.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> System.out.println("APPLICATION SUCCESSFULLY STARTED !");
    }
}
