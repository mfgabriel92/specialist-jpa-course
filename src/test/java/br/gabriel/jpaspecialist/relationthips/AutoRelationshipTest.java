package br.gabriel.jpaspecialist.relationthips;

import br.gabriel.jpaspecialist.BaseEntityManager;
import br.gabriel.jpaspecialist.model.Category;
import org.junit.Assert;
import org.junit.Test;

public class AutoRelationshipTest extends BaseEntityManager {
    @Test
    public void shouldTestAutoRelationship() {
        Category parentCategory = new Category();
        parentCategory.setName("Electronics");
        
        Category childCategory = new Category();
        childCategory.setName("Smartphone");
        childCategory.setParentCategory(parentCategory);
        
        persist(parentCategory, childCategory);
    
        Category assertCategoryParent = entityManager.find(Category.class, parentCategory.getId());
        Assert.assertFalse(assertCategoryParent.getCategories().isEmpty());
        
        Category assertCategory = entityManager.find(Category.class, childCategory.getId());
        Assert.assertNotNull(assertCategory.getParentCategory());
        Assert.assertEquals("Electronics", assertCategory.getParentCategory().getName());
    }
}
