package br.gabriel.jpaspecialist.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
@EqualsAndHashCode(of = "id")
public class Product {
    @Id
    private Integer id;
    
    private String name;
    
    private String description;
    
    private BigDecimal price;
}
