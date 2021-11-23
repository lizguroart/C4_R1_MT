/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.retos.app.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author bmao9
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user")
public class User implements Serializable{
    
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name="email",nullable=false,length=80,unique=true)
    private String email;
    @Column(name="password",nullable=false,length=50)
    private String password;
    @Column(name="name",nullable=false,length=80)
    private String name;
    
    
    
    
}
