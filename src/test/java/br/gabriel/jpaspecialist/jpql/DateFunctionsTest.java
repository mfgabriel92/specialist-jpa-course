package br.gabriel.jpaspecialist.jpql;

import br.gabriel.jpaspecialist.BaseEntityManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.TimeZone;

public class DateFunctionsTest extends BaseEntityManager {
    @Before
    public void setUp() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
    
    @Test
    public void shouldTestFunctions() {
        String jpql = "SELECT CURRENT_DATE, CURRENT_TIME, CURRENT_TIMESTAMP FROM Category c";
    
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);
        List<Object[]> list = typedQuery.getResultList();
        Assert.assertFalse(list.isEmpty());
        
        list.forEach(i -> System.out.printf("%s - %s - %s%n", i[0], i[1], i[2]));
    }
}
