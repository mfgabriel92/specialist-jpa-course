package br.gabriel.jpaspecialist.advancedmapping;

import br.gabriel.jpaspecialist.BaseEntityManager;
import br.gabriel.jpaspecialist.model.Product;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ColumnInsertableUpdatableTest extends BaseEntityManager {
    @Test
    public void shouldNotInsertUpdatedAtColumn() {
        Product product = new Product();
        product.setName("Lorem");
        product.setDescription("Lorem ipsum");
        product.setPrice(BigDecimal.TEN);
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        
        persist(product);
        
        Product assertProduct = find(Product.class, product.getId());
        Assert.assertNotNull(assertProduct.getCategories());
        Assert.assertNull(assertProduct.getUpdatedAt());
    }
}
