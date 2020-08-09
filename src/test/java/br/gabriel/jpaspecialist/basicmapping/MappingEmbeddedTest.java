package br.gabriel.jpaspecialist.basicmapping;

import br.gabriel.jpaspecialist.BaseEntityManager;
import br.gabriel.jpaspecialist.model.Address;
import br.gabriel.jpaspecialist.model.Order;
import br.gabriel.jpaspecialist.model.OrderStatus;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MappingEmbeddedTest extends BaseEntityManager {
    @Test
    public void shouldTestEmbeddedObject() {
        Address address = new Address();
        address.setPostalCode("99999");
        address.setStreet("Lorem St.");
        address.setNumber("99");
        address.setApartment("9A");
        address.setNeighborhood("Ipsum");
        address.setCity("Dolor");
        address.setState("Amet");
    
        Order order = new Order();
        order.setCreatedAt(LocalDateTime.now());
        order.setStatus(OrderStatus.WAITING);
        order.setTotal(new BigDecimal("78.60"));
        order.setAddress(address);
        
        persist(order);
        
        Order assertOrder = entityManager.find(Order.class, order.getId());
        Assert.assertNotNull(assertOrder);
        Assert.assertNotNull(assertOrder.getAddress());
    }
}
