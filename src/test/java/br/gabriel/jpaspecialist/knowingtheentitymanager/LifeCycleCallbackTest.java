package br.gabriel.jpaspecialist.knowingtheentitymanager;

import br.gabriel.jpaspecialist.BaseEntityManager;
import br.gabriel.jpaspecialist.model.Client;
import br.gabriel.jpaspecialist.model.Order;
import br.gabriel.jpaspecialist.model.OrderStatus;
import org.junit.Assert;
import org.junit.Test;

public class LifeCycleCallbackTest extends BaseEntityManager {
    @Test
    public void shouldTestCallbacks() {
        Client client = find(Client.class, 1);
    
        Order order = new Order();
        order.setClient(client);
        order.setStatus(OrderStatus.WAITING);
    
        begin();
        entityManager.persist(order);
        entityManager.flush();
    
        order.setStatus(OrderStatus.PAID);
        commit();
        clear();
        
        Order assertOrder = find(Order.class, order.getId());
        Assert.assertNotNull(assertOrder.getCreatedAt());
        Assert.assertNotNull(assertOrder.getUpdatedAt());
    }
}
