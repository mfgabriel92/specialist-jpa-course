package br.gabriel.jpaspecialist.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrderItem {
    @Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id")
    private Order order;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id")
    private Product product;
    
    private Integer quantity;
    
    private BigDecimal price;
}
