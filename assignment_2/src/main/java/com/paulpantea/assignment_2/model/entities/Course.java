package com.paulpantea.assignment_2.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Timestamp exam;

    public Course() {
        this.name = null;
        this.exam = null;
    }

    public Course(String name, Timestamp exam) {
        this.name = name;
        this.exam = exam;
    }
    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Timestamp getExam() {
        return exam;
    }
    public void setExam(Timestamp exam) {
        this.exam = exam;
    }
    @Override
    public String toString() {
        return "Course ("+name +","+ exam+")\n";
    }
}
