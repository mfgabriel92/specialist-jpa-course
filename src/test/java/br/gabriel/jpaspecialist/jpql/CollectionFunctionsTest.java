package br.gabriel.jpaspecialist.jpql;

import br.gabriel.jpaspecialist.BaseEntityManager;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.TypedQuery;
import java.util.List;

public class CollectionFunctionsTest extends BaseEntityManager {
    @Test
    public void shouldTestFunctions() {
        String jpql = "SELECT SIZE(o.items) FROM Order o";
    
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);
        List<Object[]> list = typedQuery.getResultList();
        Assert.assertFalse(list.isEmpty());
        
        list.forEach(System.out::println);
    }
}
