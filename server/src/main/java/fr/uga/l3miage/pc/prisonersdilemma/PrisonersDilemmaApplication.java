package fr.uga.l3miage.pc.prisonersdilemma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/*@EntityScan(basePackages = "fr.uga.l3miage.pc.prisonersdilemma.models")
@EnableJpaRepositories(basePackages = "fr.uga.l3miage.pc.prisonersdilemma.repositories")*/
@SpringBootApplication
public class PrisonersDilemmaApplication {
	public static void main(String[] args) {
		SpringApplication.run(PrisonersDilemmaApplication.class, args);
	}
}
