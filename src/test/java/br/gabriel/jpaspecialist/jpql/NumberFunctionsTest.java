package br.gabriel.jpaspecialist.jpql;

import br.gabriel.jpaspecialist.BaseEntityManager;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.TypedQuery;
import java.util.List;

public class NumberFunctionsTest extends BaseEntityManager {
    @Test
    public void shouldTestFunctions() {
        String jpql = "SELECT ABS(-10), MOD(127, 4), SQRT(9) FROM Order o";
    
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);
        List<Object[]> list = typedQuery.getResultList();
        Assert.assertFalse(list.isEmpty());
        
        list.forEach(i -> System.out.printf("%s - %s - %s%n", i[0], i[1], i[2]));
    }
}
