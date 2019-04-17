package com.paulpantea.assignment_2;

import com.paulpantea.assignment_2.model.entities.Client;
import com.paulpantea.assignment_2.model.repository.ClientDao;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Tests {

    @Autowired
    ClientDao clientDao;


    @Test(expected = Exception.class)
    public void testClientNotFound(){
        Client client = new Client("username", "password", false, true);
        clientDao.save(client);
        Client found = clientDao.findById(100);
        Assert.assertEquals(client, found);
    }
}
