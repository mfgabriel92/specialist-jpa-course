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
    
    @Test
    public void shouldChooseAnAttributeToReturn() {
        TypedQuery<String> typedQuery = entityManager.createQuery("SELECT o.client.name FROM Order o WHERE o.id = 1", String.class);
        List<String> orders = typedQuery.getResultList();
    
        Assert.assertFalse(orders.isEmpty());
    }
    
    @Test
    public void shouldProjectTheResult() {
        String jpql = "select id, name FROM Product";
        
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);
        List<Object[]> list = typedQuery.getResultList();
    
        Assert.assertEquals(2, list.get(0).length);
        
        list.forEach(a -> System.out.printf("%s: %s%n", a[0], a[1]));
    }
}
