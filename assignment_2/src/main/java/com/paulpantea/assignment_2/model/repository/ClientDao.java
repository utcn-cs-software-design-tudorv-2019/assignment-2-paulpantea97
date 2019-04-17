package com.paulpantea.assignment_2.model.repository;

import com.paulpantea.assignment_2.model.entities.Client;
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
public class ClientDao {

    private final EntityManager entityManager;

    public Client save(Client client){
        entityManager.persist(client);
        return client;
    }

    public void update(Client client){
        entityManager.merge(client);
    }

    public Client findById(int id){
        return entityManager.find(Client.class, id);
    }

    public Client login(String username, String password){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> query = builder.createQuery(Client.class);
        Root<Client> root = query.from(Client.class);
        query.select(root).where(builder.and(
                builder.equal(root.get("username"), username),
                builder.equal(root.get("password"), password)
        ));

        List<Client> clients = entityManager.createQuery(query).getResultList();
        return clients.isEmpty() ? null : clients.get(0);
    }

    public List<Client> view(){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> query = builder.createQuery(Client.class);
        query.select(query.from(Client.class));
        return entityManager.createQuery(query).getResultList();
    }

    public Client getLoggedClient(){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> query = builder.createQuery(Client.class);
        Root<Client> root = query.from(Client.class);
        query.select(root).where(builder.equal(root.get("isLogged"), true));

        List<Client> clients = entityManager.createQuery(query).getResultList();
        return clients.isEmpty() ? null : clients.get(0);
    }

    public void setLoggedOff(Client client){
        client.setIsLogged(false);
        update(client);
    }

    public void setLoggedIn(Client client){
        client.setIsLogged(true);
        update(client);
    }
}
