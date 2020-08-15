package br.gabriel.jpaspecialist.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrderItem {
    @EmbeddedId
    private OrderItemId id;

    @MapsId("orderId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id")
    private Order order;
    
    @MapsId("productId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id")
    private Product product;
    
    private Integer quantity;
    
    private BigDecimal price;
}
