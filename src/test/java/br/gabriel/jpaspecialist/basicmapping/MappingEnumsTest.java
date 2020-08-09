package br.gabriel.jpaspecialist.basicmapping;

import br.gabriel.jpaspecialist.BaseEntityManager;
import br.gabriel.jpaspecialist.model.Client;
import br.gabriel.jpaspecialist.model.Gender;
import org.junit.Assert;
import org.junit.Test;

public class MappingEnumsTest extends BaseEntityManager {
    @Test
    public void shouldTestEnum() {
        Client client = new Client();
        client.setName("John Doe");
        client.setGender(Gender.MALE);
    
        persist(client);
    
        Client assertClient = entityManager.find(Client.class, client.getId());
        Assert.assertNotNull(assertClient);
    }
}
