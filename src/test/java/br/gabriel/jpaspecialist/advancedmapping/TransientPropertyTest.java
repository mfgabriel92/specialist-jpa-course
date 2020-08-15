package br.gabriel.jpaspecialist.advancedmapping;

import br.gabriel.jpaspecialist.BaseEntityManager;
import br.gabriel.jpaspecialist.model.Client;
import org.junit.Assert;
import org.junit.Test;

public class TransientPropertyTest extends BaseEntityManager {
    @Test
    public void shouldTestTransientFirstName() {
        Client client = find(Client.class, 1);
        Assert.assertEquals("Gabriel", client.getFirstName());
    }
}
