package com.paulpantea.assignment_2.model.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Groups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Groups(){}

    public Groups(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Group (+name )\n";
    }
}