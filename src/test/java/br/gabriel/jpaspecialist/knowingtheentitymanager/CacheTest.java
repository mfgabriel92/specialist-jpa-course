package br.gabriel.jpaspecialist.knowingtheentitymanager;

import br.gabriel.jpaspecialist.BaseEntityManager;
import br.gabriel.jpaspecialist.model.Product;
import org.junit.Test;

public class CacheTest extends BaseEntityManager {
    @Test
    public void shouldTestFirstLevelCache() {
        Product product = find(Product.class, 1);
        System.out.println(product.getName());
        System.out.println("#############################################################3");
        Product product2 = find(Product.class, product.getId());
        System.out.println(product2.getName());
    }
}
