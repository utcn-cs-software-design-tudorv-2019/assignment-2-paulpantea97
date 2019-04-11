package com.paulpantea.assignment_2.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String pnc;
    private String address;

    public Student() {}

    public Student(int id,String name,String pnc,String address) {
        super();
        this.id = id;
        this.name = name;
        this.pnc = pnc;
        this.address=address;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPnc() {
        return pnc;
    }
    public void setPnc(String pnc) {
        this.pnc = pnc;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}