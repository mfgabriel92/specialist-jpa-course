package br.gabriel.jpaspecialist.cascadingoperations;

import br.gabriel.jpaspecialist.BaseEntityManager;
import br.gabriel.jpaspecialist.model.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

public class CascadingTypesTest extends BaseEntityManager {
    @Test
    public void shouldPersistOrderAndOrderItems() {
        Client client = find(Client.class, 1);
        Product product = find(Product.class, 1);
        
        Order order = new Order();
        order.setClient(client);
        order.setStatus(OrderStatus.WAITING);
        order.setTotal(product.getPrice());
    
        OrderItem orderItem = new OrderItem();
        orderItem.setId(new OrderItemId());
        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItem.setQuantity(3);
        orderItem.setPrice(product.getPrice());
        order.setItems(Arrays.asList(orderItem));
        
        persist(order);
    }
    
    @Test
    public void shouldPersistOrderAndNewClient() {
        Client client = new Client();
        client.setName("Fulano de Tal");
        client.setCpf("03199444447");
        client.setGender(Gender.MALE);
        client.setBirthdate(LocalDate.of(1992, 12, 6));
    
        Order order = new Order();
        order.setClient(client);
        order.setStatus(OrderStatus.WAITING);
        order.setTotal(new BigDecimal("1300"));
        
        persist(client, order);
    }
}
