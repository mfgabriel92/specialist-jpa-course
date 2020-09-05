package br.gabriel.jpaspecialist.jpql;

import br.gabriel.jpaspecialist.BaseEntityManager;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.TypedQuery;
import java.util.List;

public class ConditionalExpressionsTest extends BaseEntityManager {
    @Test
    public void shouldTestLike() {
        String jpql = "SELECT c FROM Client c WHERE c.name LIKE CONCAT('%', :name, '%') ";
    
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);
        typedQuery.setParameter("name", "%Robert%");
        
        List<Object[]> list = typedQuery.getResultList();
        Assert.assertFalse(list.isEmpty());
    }
    
    @Test
    public void shouldTestIsNull() {
        String jpql = "SELECT p FROM Product p WHERE p.photo IS NULL";
        
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);
        List<Object[]> list = typedQuery.getResultList();
        Assert.assertFalse(list.isEmpty());
    }
    
    @Test
    public void shouldTestIsEmpty() {
        String jpql = "SELECT p FROM Product p WHERE p.categories IS EMPTY";
        
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);
        List<Object[]> list = typedQuery.getResultList();
        Assert.assertFalse(list.isEmpty());
    }
}
