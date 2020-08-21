package br.gabriel.jpaspecialist.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "stocks")
@Setter
@Getter
public class Stock extends BaseEntity {
    @OneToOne(optional = false)
    @JoinColumn(
        name = "product_id",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_stocks_products")
    )
    private Product product;
    
    @Column(nullable = false)
    private Integer quantity;
}
