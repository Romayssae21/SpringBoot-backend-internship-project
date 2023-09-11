package com.Romayssae.collaborateur;

import com.Romayssae.collaborateur.config.RsaKeyProprties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProprties.class)
@SpringBootApplication
public class CollaborateurApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollaborateurApplication.class, args);
	}

}
