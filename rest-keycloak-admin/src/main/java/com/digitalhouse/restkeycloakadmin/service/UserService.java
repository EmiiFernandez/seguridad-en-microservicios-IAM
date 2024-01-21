package com.digitalhouse.restkeycloakadmin.service;

import java.util.List;

import com.digitalhouse.restkeycloakadmin.model.User;
import com.digitalhouse.restkeycloakadmin.repository.IUserRepository;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private IUserRepository userRepository;

    // Constructor que inyecta la implementacion del repositorio IUserRepository
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Metodo para buscar un usuario por su ID
    public User findById(String id) {
        // Utiliza el metodo del repositorio para obtener el usuario por su ID
        return userRepository.findById(id).orElse(null);
    }

    // Metodo para buscar una lista de usuarios por su nombre
    public List<User> findByName(String name) {
        // Utiliza el metodo del repositorio para obtener la lista de usuarios por nombre
        return userRepository.findByUsername(name);
    }
}
