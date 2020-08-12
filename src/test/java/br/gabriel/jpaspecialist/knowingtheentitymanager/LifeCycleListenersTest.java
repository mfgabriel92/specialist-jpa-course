package br.gabriel.jpaspecialist.knowingtheentitymanager;

import br.gabriel.jpaspecialist.BaseEntityManager;
import br.gabriel.jpaspecialist.model.Client;
import br.gabriel.jpaspecialist.model.Order;
import br.gabriel.jpaspecialist.model.OrderStatus;
import org.junit.Assert;
import org.junit.Test;

public class LifeCycleListenersTest extends BaseEntityManager {
    @Test
    public void shouldTestListeners() {
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
    }
}
