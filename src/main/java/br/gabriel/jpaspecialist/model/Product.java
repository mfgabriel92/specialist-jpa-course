package br.gabriel.jpaspecialist.model;

import lombok.EqualsAndHashCode;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@EqualsAndHashCode(of = "id")
public class Product {
    @Id
    private Integer id;
    
    private String name;
    
    private String description;
    
    private BigDecimal price;
}
