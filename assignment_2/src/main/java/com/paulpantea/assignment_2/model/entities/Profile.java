package com.paulpantea.assignment_2.model.entities;

import javax.persistence.*;

@Entity
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

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Groups getGroup() {
        return groups;
    }

    public void setGroup(Groups group) {
        this.groups= group;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
    @Override
    public String toString() {
        return "Profile ("+student +","+ course+","+ groups+","+ grade+")\n";
    }
}