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
@IdClass(OrderProductId.class)
public class OrderItem {
    @Include
    @Id
    @Column(name = "order_id")
    private Integer orderId;
    
    @Include
    @Id
    @Column(name = "product_id")
    private Integer productId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Order order;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;
    
    private Integer quantity;
    
    private BigDecimal price;
}
