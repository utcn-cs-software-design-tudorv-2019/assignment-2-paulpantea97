package com.paulpantea.assignment_2.model.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn
    private Student student;

    @ManyToOne
    @JoinColumn
    private Course course;

    @ManyToOne
    @JoinColumn
    private Groups groups;
    private int grade;

    public Profile() {
        this.student = null;
        this.course = null;
        this.grade = 1;
        this.groups = null;
    }

    public Profile(Student student, Course course, Groups groups, int grade) {
        super();
        this.student = student;
        this.course = course;
        this.groups = groups;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Profile ("+student +","+ course+","+ groups+","+ grade+")\n";
    }
}