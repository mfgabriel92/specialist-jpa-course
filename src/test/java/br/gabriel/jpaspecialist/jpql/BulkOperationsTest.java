package br.gabriel.jpaspecialist.jpql;

import br.gabriel.jpaspecialist.BaseEntityManager;
import br.gabriel.jpaspecialist.model.Product;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.stream.Collectors;

public class BulkOperationsTest extends BaseEntityManager {
    @Test
    public void shouldBulkInsert() {
        int count = 0;
        InputStream inputStream = BulkOperationsTest.class.getClassLoader().getResourceAsStream("products.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        
        begin();
        
        for (String line : bufferedReader.lines().collect(Collectors.toList())) {
            if (line.isBlank()) {
                continue;
            }
            
            String[] column = line.split(";");
            Product product = new Product();
            product.setName(column[0]);
            product.setDescription(column[1]);
            product.setPrice(new BigDecimal(column[2]));
            
            entityManager.persist(product);
            
            if (++count == 10) {
                flush();
                clear();
                count = 0;
            }
        }
        
        commit();
    }
}
