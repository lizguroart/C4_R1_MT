/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.retos.app.repositories.crud;

import com.proyecto.retos.app.entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author bmao9
 */
public interface UserCrudRepository extends CrudRepository<User,Integer> {
    
    //Optional<User> findEmail(String email);
    //Optional<User> findEmailAndPassword(String email, String password);

    
}

