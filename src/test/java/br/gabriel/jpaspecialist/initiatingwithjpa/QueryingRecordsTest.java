package br.gabriel.jpaspecialist.initiatingwithjpa;

import br.gabriel.jpaspecialist.BaseEntityManager;
import br.gabriel.jpaspecialist.model.Product;
import org.junit.Assert;
import org.junit.Test;

public class QueryingRecordsTest extends BaseEntityManager {
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
}
