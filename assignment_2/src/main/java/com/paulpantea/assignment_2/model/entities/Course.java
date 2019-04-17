package com.paulpantea.assignment_2.model.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data
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

    @Override
    public String toString() {
        return "Course ("+name +","+ exam+")\n";
    }
}
