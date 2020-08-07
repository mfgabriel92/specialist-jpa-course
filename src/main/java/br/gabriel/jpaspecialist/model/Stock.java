package br.gabriel.jpaspecialist.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stocks")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Stock {
    @Id
    @Include
    private Integer id;
    
    private Integer productId;
    
    private Integer quantity;
}
