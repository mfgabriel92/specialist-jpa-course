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
    
        persist(product);
        
        Product assertProduct = entityManager.find(Product.class, product.getId());
        Assert.assertNotNull(assertProduct);
    }
    
    @Test
    public void shouldRemoveAProduct() {
        Product product = entityManager.find(Product.class, 3);
    
        remove(product);

        Product assertProduct = entityManager.find(Product.class, 3);
        Assert.assertNull(assertProduct);
    }
    
    @Test
    public void shouldUpdateAProduct() {
        Product product = new Product();
        product.setId(1);
        product.setName("Kindle Paperwhite");
        product.setDescription("Get the new Kindle Paperwhite");
        product.setPrice(new BigDecimal("399.00"));
        
        merge(product);
    
        Product assertProduct = entityManager.find(Product.class, product.getId());
        Assert.assertNotNull(assertProduct);
        Assert.assertEquals("Kindle Paperwhite", assertProduct.getName());
    }
    
    @Test
    public void shouldUpdateAManagedObject() {
        Product product = entityManager.find(Product.class, 1);
    
        entityManager.getTransaction().begin();
        product.setName("Kindle Paperwhite 2nd Generation");
        entityManager.getTransaction().commit();
        entityManager.clear();
        
        Product assertProduct = entityManager.find(Product.class, product.getId());
        Assert.assertNotNull(assertProduct);
        Assert.assertEquals("Kindle Paperwhite 2nd Generation", assertProduct.getName());
    }
    
    @Test
    public void shouldInsertNewObjectWithMerge() {
        Product product = new Product();
        product.setId(4);
        product.setName("Microsoft Office");
        product.setDescription("Collaborate for free with online versions of Microsoft Word, PowerPoint, Excel, and OneNote. Save documents, spreadsheets, and presentations online");
        product.setPrice(new BigDecimal("299.00"));
        
        persist(product);
        
        Product assertProduct = entityManager.find(Product.class, product.getId());
        Assert.assertNotNull(assertProduct);
    }
    
    @Test
    public void shouldPreventADatabaseOperation() {
        Product product = entityManager.find(Product.class, 1);
        entityManager.detach(product);
        
        entityManager.getTransaction().begin();
        product.setName("Kindle Paperwhite 2nd Generation");
        entityManager.getTransaction().commit();
        entityManager.clear();
        
        Product assertProduct = entityManager.find(Product.class, product.getId());
        Assert.assertNotNull(assertProduct);
        Assert.assertEquals("Kindle", assertProduct.getName());
    }
}
