package br.gabriel.jpaspecialist.advancedmapping;

import br.gabriel.jpaspecialist.BaseEntityManager;
import br.gabriel.jpaspecialist.model.CardPayment;
import br.gabriel.jpaspecialist.model.Order;
import br.gabriel.jpaspecialist.model.Payment;
import br.gabriel.jpaspecialist.model.PaymentStatus;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.TypedQuery;
import java.util.List;

public class InheritanceTest extends BaseEntityManager {
    @Test
    public void shouldInsertPayment() {
        Order order = find(Order.class, 1);
        CardPayment cardPayment = new CardPayment();
        cardPayment.setNumber("1111 3333 5555 7777");
        cardPayment.setStatus(PaymentStatus.RECEIVED);
        cardPayment.setOrder(order);
        
        persist(cardPayment);
        clear();
        
        Order assertOrder = find(Order.class, order.getId());
        Assert.assertNotNull(assertOrder.getPayment());
    }
    
    @Test
    public void shouldFetchPayments() {
        TypedQuery<Payment> query = entityManager.createQuery("SELECT p FROM Payment p", Payment.class);
        List<Payment> payments = query.getResultList();
    
        Assert.assertFalse(payments.isEmpty());
    }
}
