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
    
    protected <T> T find(Class<T> clazz, Integer id) {
        return entityManager.find(clazz, id);
    }
    
    protected void persist(Object ...entities) {
        entityManager.getTransaction().begin();
        Arrays.stream(entities).forEach(entity -> entityManager.persist(entity));
        entityManager.getTransaction().commit();
        entityManager.clear();
    }
    
    protected void merge(Object ...entities) {
        entityManager.getTransaction().begin();
        Arrays.stream(entities).forEach(entity -> entityManager.merge(entity));
        entityManager.getTransaction().commit();
        entityManager.clear();
    }
    
    protected void remove(Object ...entities) {
        entityManager.getTransaction().begin();
        Arrays.stream(entities).forEach(entity -> entityManager.remove(entity));
        entityManager.getTransaction().commit();
    }
}
