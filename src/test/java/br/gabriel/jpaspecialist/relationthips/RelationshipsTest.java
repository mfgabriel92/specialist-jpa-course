package br.gabriel.jpaspecialist.relationthips;

import br.gabriel.jpaspecialist.BaseEntityManager;
import br.gabriel.jpaspecialist.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

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
    
    @Test
    public void shouldTestManyToOneChallengeWithOrderItem() {
        Client client = entityManager.find(Client.class, 1);
        Product product = entityManager.find(Product.class, 1);
    
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setQuantity(3);
        orderItem.setPrice(new BigDecimal(orderItem.getQuantity()).multiply(orderItem.getProduct().getPrice()));
    
        Order order = new Order();
        order.setTotal(orderItem.getPrice());
        order.setStatus(OrderStatus.WAITING);
        order.setClient(client);
        order.setCreatedAt(LocalDateTime.now());
    
        orderItem.setOrder(order);
    
        persist(order, orderItem);
    
        Order assertOrder = entityManager.find(Order.class, order.getId());
        OrderItem assertOrderItem = entityManager.find(OrderItem.class, orderItem.getId());
        Assert.assertFalse(assertOrder.getItems().isEmpty());
        Assert.assertNotNull(assertOrderItem.getOrder());
        Assert.assertNotNull(assertOrderItem.getProduct());
    }
    
    @Test
    public void shouldTestOneToMany() {
        Client client = entityManager.find(Client.class, 1);
        Product product = entityManager.find(Product.class, 1);
        
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setQuantity(3);
        orderItem.setPrice(new BigDecimal(orderItem.getQuantity()).multiply(orderItem.getProduct().getPrice()));
        
        Order order = new Order();
        order.setTotal(orderItem.getPrice());
        order.setStatus(OrderStatus.WAITING);
        order.setClient(client);
        order.setCreatedAt(LocalDateTime.now());
        
        orderItem.setOrder(order);
        
        persist(order, orderItem);
        
        Client assertClient = entityManager.find(Client.class, client.getId());
        Assert.assertFalse(assertClient.getOrders().isEmpty());
    }
    
    @Test
    public void shouldTestManyToMany() {
        Product product = entityManager.find(Product.class, 1);
        Category category = entityManager.find(Category.class, 1);
        
        product.setCategories(Arrays.asList(category));
        persist(product);
    
        Product assertProduct = entityManager.find(Product.class, product.getId());
        Assert.assertFalse(assertProduct.getCategories().isEmpty());
    }
    
    @Test
    public void shouldTestOneToOne() {
        Order order = entityManager.find(Order.class, 1);
        
        Invoice invoice = new Invoice();
        invoice.setOrder(order);
        invoice.setXml("FOO");
        invoice.setCreatedAt(new Date());
        
        persist(invoice);
        
        Order assertOrder = entityManager.find(Order.class, order.getId());
        Assert.assertNotNull(assertOrder.getInvoice());
    }
}
