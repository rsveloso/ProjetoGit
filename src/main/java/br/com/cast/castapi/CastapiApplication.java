package br.com.cast.castapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude= {
		DataSourceAutoConfiguration.class,    //não usar a configuração do DataSource
		HibernateJpaAutoConfiguration.class}) // não usar a configuração do JPA
public class CastapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CastapiApplication.class, args);
	}
}
