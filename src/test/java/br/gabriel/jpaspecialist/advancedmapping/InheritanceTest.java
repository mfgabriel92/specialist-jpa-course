package br.gabriel.jpaspecialist.advancedmapping;

import br.gabriel.jpaspecialist.BaseEntityManager;
import br.gabriel.jpaspecialist.model.*;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.TypedQuery;
import java.util.List;

public class InheritanceTest extends BaseEntityManager {
    @Test
    public void shouldInsertPayment() {
        Order order1 = find(Order.class, 1);
        Order order2 = find(Order.class, 2);

        CardPayment cardPayment = new CardPayment();
        cardPayment.setNumber("1111 3333 5555 7777");
        cardPayment.setStatus(PaymentStatus.RECEIVED);
        cardPayment.setOrder(order1);
    
        SlipPayment slipPayment = new SlipPayment();
        slipPayment.setBarCode("A-0010-Z");
        slipPayment.setStatus(PaymentStatus.PROCESSING);
        slipPayment.setOrder(order2);
        
        persist(cardPayment, slipPayment);
        clear();
        
        Order assertOrder1 = find(Order.class, order1.getId());
        Assert.assertNotNull(assertOrder1.getPayment());
        Assert.assertEquals("RECEIVED", assertOrder1.getPayment().getStatus().name());
    
        Order assertOrder2 = find(Order.class, order2.getId());
        Assert.assertNotNull(assertOrder2.getPayment());
        Assert.assertEquals("PROCESSING", assertOrder2.getPayment().getStatus().name());
    }
    
    @Test
    public void shouldFetchPayments() {
        TypedQuery<Payment> query = entityManager.createQuery("SELECT p FROM Payment p", Payment.class);
        List<Payment> payments = query.getResultList();
    
        Assert.assertFalse(payments.isEmpty());
    }
}
