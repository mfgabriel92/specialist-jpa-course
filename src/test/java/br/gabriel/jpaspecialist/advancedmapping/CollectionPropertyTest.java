package br.gabriel.jpaspecialist.advancedmapping;

import br.gabriel.jpaspecialist.BaseEntityManager;
import br.gabriel.jpaspecialist.model.Attribute;
import br.gabriel.jpaspecialist.model.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class CollectionPropertyTest extends BaseEntityManager {
    @Test
    public void shouldTestCollectionProperty() {
        begin();
        
        Product product = find(Product.class, 1);
        product.setTags(Arrays.asList("ebook", "digital", "book"));
        
        commit();
        clear();
        
        Product assertProduct = find(Product.class, product.getId());
        Assert.assertFalse(assertProduct.getTags().isEmpty());
    }
    
    @Test
    public void shouldTestCollectionObject() {
        begin();
        
        Product product = find(Product.class, 1);
        product.setAttributes(Arrays.asList(
            new Attribute("screenSize", "1280x768"),
            new Attribute("color", "Black")
        ));
        
        commit();
        clear();
        
        Product assertProduct = find(Product.class, product.getId());
        Assert.assertFalse(assertProduct.getAttributes().isEmpty());
    }
}
