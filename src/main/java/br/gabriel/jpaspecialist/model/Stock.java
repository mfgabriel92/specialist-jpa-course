package br.gabriel.jpaspecialist.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;

import javax.persistence.*;

@Entity
@Table(name = "stocks")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Stock {
    @Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @OneToOne(optional = false)
    @JoinColumn(name = "product_id")
    private Product product;
    
    private Integer quantity;
}
