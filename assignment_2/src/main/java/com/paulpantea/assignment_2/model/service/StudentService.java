package com.paulpantea.assignment_2.model.service;

import com.paulpantea.assignment_2.model.entities.Client;
import com.paulpantea.assignment_2.model.entities.Student;
import com.paulpantea.assignment_2.model.repository.ClientDao;
import com.paulpantea.assignment_2.model.repository.StudentDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.lang.reflect.Field;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentDao studentDao;
    private final ClientDao clientDao;

    @Transactional
    public void addStudent(String name, String pnc, String address, int clientId) {
        Client client = clientDao.findById(clientId);
        studentDao.save(new Student(0, name, pnc, address, client));
    }

    @Transactional
    public void addStudent(String name, String pnc, String address) {
        Client client = clientDao.getLoggedClient();
        System.out.println(client);
        Student student = findByLoggedUser();

        System.out.println(student);

        if(student == null)
            studentDao.save(new Student(0, name, pnc, address, client));
    }

    @Transactional
    public ArrayList<Student> viewStudents(){
        return (ArrayList<Student>) studentDao.view();
    }

    @Transactional
    public void delete(int id) {
        Student student = studentDao.findById(id);
        studentDao.delete(student);
    }

    @Transactional
    public Student findById(int id) {
        return studentDao.findById(id);
    }

    @Transactional
    public Student findByLoggedUser() {
        Client client = clientDao.getLoggedClient();
        System.out.println(client);
        return studentDao.findByClientId(client);
    }

    @Transactional
    public void editStudent(int id, String name, String pnc, String address) {
        Client client = clientDao .getLoggedClient();
        studentDao.update(new Student(id, name, pnc, address, client));
    }

    @Transactional
    public void editStudent(int id, String name, String pnc, String address, int clientId) {
        Client client = clientDao.findById(clientId);
        Student student = new Student(id, name, pnc, address, client);
        studentDao.update(student);
    }

    public JTable createTable(ArrayList<Student> objects) {

        Object[] coloane = new String[objects.get(0).getClass().getDeclaredFields().length];
        Object[][] randuri = new Object[objects.size()][objects.get(0).getClass().getDeclaredFields().length];

        if(objects.size() > 0) {

            for(int i = 0; i <objects.get(0).getClass().getDeclaredFields().length; i++) {

                Field field = objects.get(0).getClass().getDeclaredFields()[i];
                field.setAccessible(true);
                coloane[i] = objects.get(0).getClass().getDeclaredFields()[i].getName();
            }
        }

        for(int i = 0; i < objects.size(); i++) {
            for(int j = 0; j < objects.get(i).getClass().getDeclaredFields().length; j++) {
                try {
                    Field field = objects.get(i).getClass().getDeclaredFields()[j];
                    field.setAccessible(true);
                    randuri[i][j] = field.get(objects.get(i));
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (SecurityException e) {
                    e.printStackTrace();
                }
            }
        }

        JTable afisare = new JTable(randuri, coloane);
        return afisare;
    }
}
