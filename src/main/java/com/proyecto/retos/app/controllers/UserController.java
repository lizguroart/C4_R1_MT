/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.retos.app.controllers;

import com.proyecto.retos.app.entities.User;
import com.proyecto.retos.app.services.UserService;
import static java.lang.System.in;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lizguro
 */

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService service;
    
    //lista de usuarios
    @GetMapping("/all")
    public List<User> findAllUser(){
        return service.getAll();
    }
    
    //autenticacion correos existentes
    @GetMapping("/{email}")
    public boolean findAllAdres(@PathVariable("email")String email){
        return service.findAdress(email);
        
    }
    
    //autenticacion al ingreso
    @GetMapping("{email}/{password}")
    public User findUserExistend(@PathVariable("email")String email,@PathVariable("password") String password){
        return service.findExistens(email, password);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User user){
        
         return service.save(user);  
    }
    
    
    
}
