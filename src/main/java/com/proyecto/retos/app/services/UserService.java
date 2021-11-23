/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.retos.app.services;

import com.proyecto.retos.app.entities.User;
import com.proyecto.retos.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bmao9
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;
    
    public List<User>getAll(){
        return repository.getAll();
    }
    
    public boolean findAdress(String email){
        List<User>usuarios = repository.getAll();
        boolean r = false;
        for(User x : usuarios){
            if (x.getEmail().equals(email)){
                r = true;
            }
        }
        return r;
    }
    
    public User findExistens(String email, String password){
        List<User>usuarios = repository.getAll();
        User usuarioSinRegistro = new User();
        User usuarioConRegistro = new User();
        int validacion = 0;
        for(User x : usuarios){
            if(x.getEmail().equals(email) && x.getPassword().equals(password)){
                validacion = 1;
                usuarioConRegistro = x;   
            }
            else{
                User usuarioSinRegistro1 = new User(null,email, password, "NO DEFINIDO");
                usuarioSinRegistro = usuarioSinRegistro1;
                
            }   
        }
        if (validacion == 0){
            return usuarioSinRegistro;
        }
        else{
            return usuarioConRegistro;
        }
    }
    
    public User save(User user){
        if(user.getId()==null){
            return repository.save(user);
        }
        else{
            Optional<User> resultado = repository.getUser(user.getId());
            if (resultado.isPresent()){
                return user;
            }
            else{
                return repository.save(user);
            }
        }
    }
    
}
