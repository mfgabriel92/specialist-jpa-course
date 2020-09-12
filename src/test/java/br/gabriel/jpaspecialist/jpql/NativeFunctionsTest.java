package br.gabriel.jpaspecialist.jpql;

import br.gabriel.jpaspecialist.BaseEntityManager;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.TypedQuery;
import java.util.List;

public class NativeFunctionsTest extends BaseEntityManager {
    @Test
    public void shouldTest() {
        String jpql = "SELECT FUNCTION('dayname', c.createdAt) FROM Category c";
    
        TypedQuery<String> typedQuery = entityManager.createQuery(jpql, String.class);
        List<String> list = typedQuery.getResultList();
        Assert.assertFalse(list.isEmpty());
    
        list.forEach(System.out::println);
    }
}
