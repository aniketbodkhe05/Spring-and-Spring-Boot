package in.aniket.crudSpringbootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication
public class CrudSpringbootDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CrudSpringbootDemoApplication.class, args);
	}

}
