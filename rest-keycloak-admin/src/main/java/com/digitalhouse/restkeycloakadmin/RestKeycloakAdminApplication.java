package com.digitalhouse.restkeycloakadmin;

import com.digitalhouse.restkeycloakadmin.configuration.KeycloakClientConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(KeycloakClientConfiguration.class)
public class RestKeycloakAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestKeycloakAdminApplication.class, args);
	}

}
