package br.gabriel.jpaspecialist.jpql;

import br.gabriel.jpaspecialist.BaseEntityManager;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.TypedQuery;
import java.util.List;

public class GroupByTest extends BaseEntityManager {
    @Test
    public void shouldGroupProductsByCategory() {
        String jpql = "SELECT c.name, COUNT(p.id) FROM Category c JOIN c.products p GROUP BY c.id";
    
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);
        List<Object[]> list = typedQuery.getResultList();
        Assert.assertFalse(list.isEmpty());
    
        list.forEach(i -> System.out.printf("%s: %s\n", i[0], i[1]));
    }
    
    @Test
    public void shouldGroupSalesPerMonth() {
        String jpql = "SELECT CONCAT(FUNCTION('year', o.createdAt), '/', FUNCTION('monthname', o.createdAt) ), SUM(o.total) " +
            "FROM Order o " +
            "GROUP BY FUNCTION('year', o.createdAt), FUNCTION('month', o.createdAt) ";
        
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);
        List<Object[]> list = typedQuery.getResultList();
        Assert.assertFalse(list.isEmpty());
        
        list.forEach(i -> System.out.printf("%s: %s\n", i[0], i[1]));
    }
    
    @Test
    public void shouldTestHaving() {
        String jpql = "SELECT c.name, SUM(oi.price) FROM OrderItem oi JOIN oi.product p JOIN p.categories c GROUP BY c.id HAVING SUM(oi.price) > 1000";
    
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);
        List<Object[]> list = typedQuery.getResultList();
        Assert.assertFalse(list.isEmpty());
    
        list.forEach(i -> System.out.printf("%s: %s\n", i[0], i[1]));
    }
}
