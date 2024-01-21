package com.digitalhouse.restkeycloakadmin.controller;

import java.util.List;

import com.digitalhouse.restkeycloakadmin.model.User;
import com.digitalhouse.restkeycloakadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")  // Ruta base para todos los endpoints en este controlador
public class UserRestController {

    @Autowired
    private UserService userService;

    // Endpoint para obtener un usuario por su ID
    @GetMapping("user/{id}")
    public User getById(@PathVariable String id) {
        return userService.findById(id);
    }

    // Endpoint para obtener una lista de usuarios por su nombre
    @GetMapping("users/{name}")
    public List<User> getByName(@PathVariable String name) {
        return userService.findByName(name);
    }
}
