package br.gabriel.jpaspecialist.jpql;

import br.gabriel.jpaspecialist.BaseEntityManager;
import br.gabriel.jpaspecialist.model.Product;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.TypedQuery;
import java.util.List;

public class SubqueriesTest extends BaseEntityManager {
    @Test
    public void shouldDoSubquery() {
        String jpql = "SELECT p " +
            "FROM Product p " +
            "WHERE p.price = (SELECT MAX(price) FROM Product)";
    
        TypedQuery<Product> typedQuery = entityManager.createQuery(jpql, Product.class);
        List<Product> list = typedQuery.getResultList();
        Assert.assertFalse(list.isEmpty());
    }
}
