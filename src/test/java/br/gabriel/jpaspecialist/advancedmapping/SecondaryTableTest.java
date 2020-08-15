package br.gabriel.jpaspecialist.advancedmapping;

import br.gabriel.jpaspecialist.BaseEntityManager;
import br.gabriel.jpaspecialist.model.Client;
import br.gabriel.jpaspecialist.model.Gender;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class SecondaryTableTest extends BaseEntityManager {
    @Test
    public void shouldTestSecondaryTable() {
        Client client = new Client();
        client.setName("Charles Robert Darwin");
        client.setGender(Gender.MALE);
        client.setBirthdate(LocalDate.of(1809, 2, 12));
        
        persist(client);
        
        Client assertClient = find(Client.class, client.getId());
        Assert.assertNotNull(assertClient.getGender());
    }
}
