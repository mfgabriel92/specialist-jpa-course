package br.gabriel.jpaspecialist;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;

public class BaseEntityManager {
    protected static EntityManagerFactory entityManagerFactory;
    
    protected static EntityManager entityManager;
    
    @BeforeClass
    public static void setUpBeforeClass() {
        entityManagerFactory = Persistence.createEntityManagerFactory("JPA-Specialist-PU");
    }
    
    @Before
    public void setUp() {
        entityManager = entityManagerFactory.createEntityManager();
    }
    
    @After
    public void tearDown() {
        entityManager.close();
    }
    
    @AfterClass
    public static void tearDownAfterClass() {
        entityManagerFactory.close();
    }
    
    protected void begin() {
        entityManager.getTransaction().begin();
    }
    
    protected void commit() {
        entityManager.getTransaction().commit();
        clear();
    }
    
    protected void rollback() {
        entityManager.getTransaction().rollback();
    }
    
    protected void clear() {
        entityManager.clear();
    }
    
    protected void flush() {
        entityManager.flush();
    }
    
    protected <T> T find(Class<T> clazz, Integer id) {
        return entityManager.find(clazz, id);
    }
    
    protected void persist(Object ...entities) {
        begin();
        Arrays.stream(entities).forEach(entity -> entityManager.persist(entity));
        commit();
    }
    
    protected void merge(Object ...entities) {
        begin();
        Arrays.stream(entities).forEach(entity -> entityManager.merge(entity));
        commit();
    }
    
    protected void remove(Object ...entities) {
        begin();
        Arrays.stream(entities).forEach(entity -> entityManager.remove(entity));
        commit();
    }
}
