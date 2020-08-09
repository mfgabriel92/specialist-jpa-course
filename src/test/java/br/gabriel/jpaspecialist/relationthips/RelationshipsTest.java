package br.gabriel.jpaspecialist.relationthips;

import br.gabriel.jpaspecialist.BaseEntityManager;
import br.gabriel.jpaspecialist.model.Client;
import br.gabriel.jpaspecialist.model.Order;
import br.gabriel.jpaspecialist.model.OrderStatus;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RelationshipsTest extends BaseEntityManager {
    @Test
    public void shouldTestManyToOne() {
        Client client = entityManager.find(Client.class, 1);
        Order order = new Order();
        order.setTotal(new BigDecimal("18.75"));
        order.setStatus(OrderStatus.WAITING);
        order.setClient(client);
        order.setCreatedAt(LocalDateTime.now());
        
        persist(order);
    
        Order assertOrder = entityManager.find(Order.class, order.getId());
        Assert.assertNotNull(assertOrder);
        Assert.assertNotNull(assertOrder.getClient());
    }
}
