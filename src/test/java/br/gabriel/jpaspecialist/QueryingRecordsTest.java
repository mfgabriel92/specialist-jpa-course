package br.gabriel.jpaspecialist;

import br.gabriel.jpaspecialist.model.Product;
import org.junit.*;

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
    
    @Test
    public void shouldFindProductByID() {
        Product product = entityManager.find(Product.class, 1);
        
        Assert.assertNotNull(product);
        Assert.assertEquals("Kindle", product.getName());
    }
    
    @Test
    public void shouldRefreshTheReference() {
        Product product = entityManager.find(Product.class, 1);
        product.setName("Microsoft Surface Pro");
        
        entityManager.refresh(product);
        
        Assert.assertNotNull(product);
        Assert.assertEquals("Kindle", product.getName());
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
