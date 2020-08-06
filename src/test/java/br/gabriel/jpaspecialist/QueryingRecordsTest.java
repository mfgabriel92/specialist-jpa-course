package br.gabriel.jpaspecialist;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class QueryingRecordsTest {
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    
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
}
