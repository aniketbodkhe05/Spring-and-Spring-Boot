package in.springcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("in.springcore")
public class Appconfig {

    @Bean
    public User createUser(){
        return new User("Aniket",19);
    }
}
