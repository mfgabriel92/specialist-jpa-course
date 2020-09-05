package br.gabriel.jpaspecialist.advancedmapping;

import br.gabriel.jpaspecialist.BaseEntityManager;
import br.gabriel.jpaspecialist.model.Product;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ColumnInsertableUpdatableTest extends BaseEntityManager {
    @Test
    public void shouldNotInsertUpdatedAtColumn() {
        Product product = new Product();
        product.setName("Lorem");
        product.setDescription("Lorem ipsum");
        product.setPrice(BigDecimal.TEN);
        
        persist(product);
        
        Product assertProduct = find(Product.class, product.getId());
        Assert.assertNotNull(assertProduct.getCategories());
        Assert.assertNull(assertProduct.getUpdatedAt());
    }
}
