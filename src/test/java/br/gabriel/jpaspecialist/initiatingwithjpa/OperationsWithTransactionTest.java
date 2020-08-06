package br.gabriel.jpaspecialist.initiatingwithjpa;

import br.gabriel.jpaspecialist.BaseEntityManager;
import org.junit.Test;

public class OperationsWithTransactionTest extends BaseEntityManager {
    @Test
    public void openAndCloseTransaction() {
//        Product product = new Product();
        
        entityManager.getTransaction().begin();
//        entityManager.persist(product);
//        entityManager.merge(product);
//        entityManager.remove(product);
        entityManager.getTransaction().commit();
    }
}
