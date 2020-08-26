package br.gabriel.jpaspecialist.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stocks")
@Setter
@Getter
public class Stock extends BaseEntity {
    @OneToOne(optional = false)
    @JoinColumn(name = "product_id")
    private Product product;
    
    private Integer quantity;
}
