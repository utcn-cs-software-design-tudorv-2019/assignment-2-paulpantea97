package com.paulpantea.assignment_2.model.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username,password;
    private Boolean isAdmin;
    private Boolean isLogged;

    public Client(){}

    public Client(String username, String password, Boolean isAdmin, Boolean isLogged) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.isLogged = isLogged;
    }

    //public String toString(){
   //     return "User(" + username + ", " + isAdmin + ")\n";
   // }
}
