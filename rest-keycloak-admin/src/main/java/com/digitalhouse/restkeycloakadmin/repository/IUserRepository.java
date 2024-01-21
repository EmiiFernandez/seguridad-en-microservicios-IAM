package com.digitalhouse.restkeycloakadmin.repository;

import com.digitalhouse.restkeycloakadmin.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {

    Optional<User> findById(String id);

    List<User> findByUsername(String username);
}