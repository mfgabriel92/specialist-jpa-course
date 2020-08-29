package br.gabriel.jpaspecialist.jpql;

import br.gabriel.jpaspecialist.BaseEntityManager;
import br.gabriel.jpaspecialist.model.Order;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.TypedQuery;
import java.util.List;

public class BasicJPQLTest extends BaseEntityManager {
    @Test
    public void shouldFindById() {
        TypedQuery<Order> typedQuery = entityManager.createQuery("SELECT o FROM Order o WHERE o.id = 1", Order.class);
        List<Order> orders = typedQuery.getResultList();
    
        Assert.assertFalse(orders.isEmpty());
    }
}
