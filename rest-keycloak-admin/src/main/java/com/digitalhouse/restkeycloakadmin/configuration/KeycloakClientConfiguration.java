package com.digitalhouse.restkeycloakadmin.configuration;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

// Representa la configuracion del cliente REST para interactuar con Keycloak
@Component
@ConfigurationProperties(prefix = "keycloak")
public class KeycloakClientConfiguration {

    // Valor del realm obtenido desde la configuracion
    @Value("${dh.keycloak.realm}")
    private String realm;

    // URL del servidor de Keycloak obtenida desde la configuracion
    @Value("${dh.keycloak.serverurl}")
    private String serverurl;

    // ID del cliente obtenido desde la configuracion
    @Value("${dh.keycloak.clientid}")
    private String clientid;

    // Clave secreta del cliente obtenida desde la configuracion
    @Value("${dh.keycloak.clientsecret}")
    private String clientsecret;

    // Metodo para crear y devolver una instancia de Keycloak configurada
    @Bean
    public Keycloak getInstance() {
        return KeycloakBuilder.builder()
                .serverUrl(serverurl)
                .realm(realm)
                .clientId(clientid)
                .clientSecret(clientsecret)
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .build();
    }
}
