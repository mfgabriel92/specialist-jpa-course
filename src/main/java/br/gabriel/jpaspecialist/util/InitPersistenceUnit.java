package br.gabriel.jpaspecialist.util;

import br.gabriel.jpaspecialist.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InitPersistenceUnit {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-Specialist-PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
    
        Product product = entityManager.find(Product.class, 1);
        System.out.println(product.getName());
        
        entityManager.close();
        entityManagerFactory.close();
    }
}
