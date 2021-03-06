package br.gabriel.jpaspecialist.advancedmapping;

import br.gabriel.jpaspecialist.BaseEntityManager;
import br.gabriel.jpaspecialist.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CompositeKeyTest extends BaseEntityManager {
    @Test
    public void shouldSaveCompositeId() {
        entityManager.getTransaction().begin();
        
        Client client = find(Client.class, 1);
        Product product = find(Product.class, 1);
        
        Order order = new Order();
        order.setTotal(new BigDecimal("100.00"));
        order.setStatus(OrderStatus.WAITING);
        order.setClient(client);
        
        entityManager.persist(order);
        entityManager.flush();
        
        OrderItem orderItem = new OrderItem();
        orderItem.setId(new OrderItemId(order.getId(), product.getId()));
        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItem.setQuantity(3);
        orderItem.setPrice(new BigDecimal("300.0"));
        
        entityManager.persist(orderItem);
        entityManager.getTransaction().commit();
        entityManager.clear();
        
        Order assertOrder = find(Order.class, order.getId());
        Assert.assertNotNull(assertOrder);
        Assert.assertFalse(assertOrder.getItems().isEmpty());
    }
    
    @Test
    public void shouldFindByCompositeId() {
        OrderItem orderItem = entityManager.find(OrderItem.class, new OrderItemId(1, 1));
        Assert.assertNotNull(orderItem);
    }
}
