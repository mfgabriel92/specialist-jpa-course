package br.gabriel.jpaspecialist.jpql;

import br.gabriel.jpaspecialist.BaseEntityManager;
import br.gabriel.jpaspecialist.model.PaymentStatus;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public class ParamsTest extends BaseEntityManager {
    @Test
    public void shouldTestQueryWithParams() {
        String jpql = "SELECT o FROM Order o WHERE o.id = :id AND o.payment.status = :status";
    
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);
        typedQuery.setParameter("id", 1);
        typedQuery.setParameter("status", PaymentStatus.RECEIVED);
        
        List<Object[]> list = typedQuery.getResultList();
        Assert.assertFalse(list.isEmpty());
    }
    
    @Test
    public void shouldTestQueryWithDateParams() {
        String jpql = "SELECT i FROM Invoice i WHERE i.createdAt <= :date";
    
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);
        typedQuery.setParameter("date", new Date(), TemporalType.TIMESTAMP);
        
        List<Object[]> list = typedQuery.getResultList();
        Assert.assertFalse(list.isEmpty());
    }
}
