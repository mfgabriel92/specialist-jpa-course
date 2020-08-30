package br.gabriel.jpaspecialist.jpql;

import br.gabriel.jpaspecialist.BaseEntityManager;
import org.junit.Test;

import javax.persistence.TypedQuery;
import java.util.List;

public class JoinTest extends BaseEntityManager {
    @Test
    public void shouldDoJoin() {
        String jpql = "select p, py FROM Order p INNER JOIN p.payment py";
    
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);
        List<Object[]> list = typedQuery.getResultList();
    
        System.out.println(list);
    }
}
