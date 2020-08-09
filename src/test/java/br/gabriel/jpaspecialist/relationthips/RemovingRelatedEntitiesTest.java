package br.gabriel.jpaspecialist.relationthips;

import br.gabriel.jpaspecialist.BaseEntityManager;
import br.gabriel.jpaspecialist.model.Order;
import org.junit.Assert;
import org.junit.Test;

public class RemovingRelatedEntitiesTest extends BaseEntityManager {
    @Test
    public void shouldTestAutoRelationship() {
        Order order = entityManager.find(Order.class, 1);
        
        Assert.assertFalse(order.getItems().isEmpty());
        
        order.getItems().forEach(i -> entityManager.remove(i));
        remove(order);
    
        Order assertOrder = entityManager.find(Order.class, 1);
        Assert.assertNull(assertOrder);
    }
}
