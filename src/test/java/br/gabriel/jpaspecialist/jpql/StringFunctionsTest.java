package br.gabriel.jpaspecialist.jpql;

import br.gabriel.jpaspecialist.BaseEntityManager;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.TypedQuery;
import java.util.List;

public class StringFunctionsTest extends BaseEntityManager {
    @Test
    public void shouldApplyConcat() {
        String jpql = "SELECT c, concat('Category: ', c.name) FROM Category c";
    
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);
        List<Object[]> list = typedQuery.getResultList();
        Assert.assertFalse(list.isEmpty());
    }
    
    @Test
    public void shouldApplyLength() {
        String jpql = "SELECT c, length(c.name) FROM Category c";
        
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);
        List<Object[]> list = typedQuery.getResultList();
        Assert.assertFalse(list.isEmpty());
    }
    
    @Test
    public void shouldApplyLocate() {
        String jpql = "SELECT c, locate('a', c.name) FROM Category c";
        
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);
        List<Object[]> list = typedQuery.getResultList();
        Assert.assertFalse(list.isEmpty());
    }
    
    @Test
    public void shouldApplySubstring() {
        String jpql = "SELECT c, substring(c.name, 1, 3) FROM Category c";
        
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);
        List<Object[]> list = typedQuery.getResultList();
        Assert.assertFalse(list.isEmpty());
    }
    
    @Test
    public void shouldApplyLower() {
        String jpql = "SELECT c, lower(c.name) FROM Category c";
        
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);
        List<Object[]> list = typedQuery.getResultList();
        Assert.assertFalse(list.isEmpty());
    }
    
    @Test
    public void shouldApplyUpper() {
        String jpql = "SELECT c, upper(c.name) FROM Category c";
        
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);
        List<Object[]> list = typedQuery.getResultList();
        Assert.assertFalse(list.isEmpty());
    }
    
    @Test
    public void shouldApplyTrim() {
        String jpql = "SELECT c, trim(c.name) FROM Category c";
        
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);
        List<Object[]> list = typedQuery.getResultList();
        Assert.assertFalse(list.isEmpty());
    }
}
