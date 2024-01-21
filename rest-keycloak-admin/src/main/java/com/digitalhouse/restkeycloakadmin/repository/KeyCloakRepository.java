package com.digitalhouse.restkeycloakadmin.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.digitalhouse.restkeycloakadmin.model.User;

@Repository
public class KeyCloakRepository implements IUserRepository {

    @Autowired
    private Keycloak keycloak;

    @Value("${dh.keycloak.realm}")
    private String realm;

    // Metodo para buscar un usuario por su ID en Keycloak
    @Override
    public Optional<User> findById(String id) {
        UserRepresentation userRepresentation = keycloak
                .realm(realm)
                .users()
                .get(id)
                .toRepresentation();
        return Optional.of(fromRepresentation(userRepresentation));
    }

    // Metodo para buscar una lista de usuarios por su nombre en Keycloak
    @Override
    public List<User> findByUsername(String username) {
        List<UserRepresentation> userRepresentation = keycloak
                .realm(realm)
                .users()
                .search(username);

        return userRepresentation.stream().map(user -> fromRepresentation(user)).collect(Collectors.toList());
    }

    // Metodo privado para mapear la representacion de usuario de Keycloak a la clase User de tu aplicacion
    private User fromRepresentation(UserRepresentation userRepresentation) {
        return new User(userRepresentation.getId(), userRepresentation.getFirstName(), userRepresentation.getLastName(), userRepresentation.getEmail());
    }
}
