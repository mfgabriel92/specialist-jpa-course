package br.gabriel.jpaspecialist;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
    
    protected void persist(Object entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
        entityManager.clear();
    }
    
    protected void remove(Object entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }
}
