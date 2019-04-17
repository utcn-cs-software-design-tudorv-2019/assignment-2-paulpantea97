package com.paulpantea.assignment_2.model.service;

import com.paulpantea.assignment_2.model.entities.Client;
import com.paulpantea.assignment_2.model.repository.ClientDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientDao clientDao;

    @Transactional
    public Client addClient(Client client){ return clientDao.save(client); }

    @Transactional
    public Client login(String username, String password) {
        return clientDao.login(username, password);
    }

    @Transactional
    public Client findById(int id) {
        return clientDao.findById(id);
    }

    @Transactional
    public void setLoggedIn(Client client) {
        clientDao.setLoggedIn(client);
        ArrayList<Client> clients = (ArrayList<Client>) clientDao.view();
        for(Client c : clients) {
            if(!c.getUsername().equals(client.getUsername()))
                clientDao.setLoggedOff(c);
        }
    }

    @Transactional
    public Client getLoggedIn() {
        return clientDao.getLoggedClient();
    }
}
