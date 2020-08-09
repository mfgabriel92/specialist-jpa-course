package br.gabriel.jpaspecialist.basicmapping;

import br.gabriel.jpaspecialist.BaseEntityManager;
import br.gabriel.jpaspecialist.model.Category;
import org.junit.Assert;
import org.junit.Test;

public class PrimaryKeyStrategyTest extends BaseEntityManager {
    @Test
    public void shouldTestGeneratedValueStrategy() {
        Category category = new Category();
        category.setName("Electronics");
    
        persist(category);
    
        Category assertCategory = entityManager.find(Category.class, category.getId());
        Assert.assertNotNull(assertCategory);
    }
}
