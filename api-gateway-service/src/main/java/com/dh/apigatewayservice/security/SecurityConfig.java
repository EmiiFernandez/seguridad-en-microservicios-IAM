package com.dh.apigatewayservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;



import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    // Metodo que configura la seguridad de la aplicacion
    @Bean
    public SecurityWebFilterChain springSsecurityFilterChain(ServerHttpSecurity http) {

        // Configuracion de la seguridad usando el builder pattern de Spring Security

        // Todas las solicitudes de intercambio deben estar autenticadas
        http.authorizeExchange((exchanges) -> exchanges.anyExchange().authenticated())
                // Configuracion para la autenticacion mediante OAuth2
                .oauth2Login(withDefaults());

        // Devuelve la configuracion completa de ServerHttpSecurity construida
        return http.build();
    }
}


/*
@Configuration: Esta anotacion marca la clase como una clase de configuracion de Spring.

@Bean: Esta anotacion indica que el metodo springSecurityFilterChain proporciona un bean de configuracion de seguridad.

http.authorizeExchange(...): Configura las reglas de autorizacion para las solicitudes de intercambio. En este caso, se exige la autenticacion para todas las solicitudes.

http.oauth2Login(withDefaults()): Configura la autenticacion mediante OAuth2. withDefaults() proporciona una configuracion predeterminada para el proceso de inicio de sesion OAuth2.

return http.build(): Devuelve la configuracion completa de ServerHttpSecurity construida.
 */
