package br.gabriel.jpaspecialist.initiatingwithjpa;

import br.gabriel.jpaspecialist.BaseEntityManager;
import br.gabriel.jpaspecialist.model.Client;
import org.junit.Assert;
import org.junit.Test;

public class CRUDExerciseTest extends BaseEntityManager {
    @Test
    public void shouldInsertANewClient() {
        Client client = new Client();
        client.setId(2);
        client.setName("Jeryanne Jane");
        
        persist(client);
        
        Client clientAssert = entityManager.find(Client.class, 2);
        Assert.assertNotNull(clientAssert);
        Assert.assertEquals("Jeryanne Jane", clientAssert.getName());
    }
    
    @Test
    public void shouldReadAClient() {
        Client client = entityManager.find(Client.class, 1);
        Assert.assertNotNull(client);
        Assert.assertEquals("Gabriel Fernandes", client.getName());
    }
    
    @Test
    public void shouldUpdateAClient() {
        Client client = entityManager.find(Client.class, 1);
        client.setName("Gabriel M. Fernandes");
        
        persist(client);
        
        Client clientAssert = entityManager.find(Client.class, 1);
        Assert.assertNotNull(clientAssert);
        Assert.assertEquals("Gabriel M. Fernandes", clientAssert.getName());
    }
    
    @Test
    public void shouldDeleteAClient() {
        Client client = entityManager.find(Client.class, 1);
        
        remove(client);
        
        Client clientAssert = entityManager.find(Client.class, 1);
        Assert.assertNull(clientAssert);
    }
}
