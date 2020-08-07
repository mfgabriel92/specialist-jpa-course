package br.gabriel.jpaspecialist.initiatingwithjpa;

import br.gabriel.jpaspecialist.BaseEntityManager;
import br.gabriel.jpaspecialist.model.Product;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OperationsWithTransactionTest extends BaseEntityManager {
    @Test
    public void shouldInsertNewProduct() {
        Product product = new Product();
        product.setId(2);
        product.setName("Apple Macbook Pro");
        product.setDescription("The most powerful notebooks featuring fast processors, incredible graphics, Touch Bar, and a spectacular Retina display");
        product.setPrice(new BigDecimal("2399.00"));
    
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
        entityManager.clear();
        
        Product assertProduct = entityManager.find(Product.class, product.getId());
        Assert.assertNotNull(assertProduct);
    }
}
