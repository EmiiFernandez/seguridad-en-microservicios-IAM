package com.digitalhouse.restkeycloakadmin.service;

import java.util.List;

import com.digitalhouse.restkeycloakadmin.model.User;
import com.digitalhouse.restkeycloakadmin.repository.IUserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> findByName(String name) {
        return userRepository.findByUsername(name);
    }
}