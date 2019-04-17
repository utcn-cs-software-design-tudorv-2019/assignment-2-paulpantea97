package com.paulpantea.assignment_2.model.repository;

import com.paulpantea.assignment_2.model.entities.Client;
import com.paulpantea.assignment_2.model.entities.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
@RequiredArgsConstructor
public class StudentDao {

    private final EntityManager entityManager;

    public List<Student> view(){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> query = builder.createQuery(Student.class);
        query.select(query.from(Student.class));
        return entityManager.createQuery(query).getResultList();
    }

    public Student save(Student student){
        entityManager.persist(student);
        return student;
    }

    public void update(Student student){
        entityManager.merge(student);
    }

    public void delete(Student student){
        entityManager.remove(student);
    }

    public Student findById(int id){
        return entityManager.find(Student.class, id);
    }

    public Student findByClientId(Client client){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> query = builder.createQuery(Student.class);
        Root<Student> root = query.from(Student.class);
        query.select(root).where(builder.equal(root.get("client"), client));

        List<Student> students = entityManager.createQuery(query).getResultList();
        System.out.println(students);
        return students.isEmpty() ? null : students.get(0);
    }
}
