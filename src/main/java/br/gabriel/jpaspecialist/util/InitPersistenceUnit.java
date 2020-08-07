package br.gabriel.jpaspecialist.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InitPersistenceUnit {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-Specialist-PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        entityManager.close();
        entityManagerFactory.close();
    }
}
