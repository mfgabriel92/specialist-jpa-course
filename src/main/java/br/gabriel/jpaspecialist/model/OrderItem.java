package br.gabriel.jpaspecialist.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrderItem {
    @EmbeddedId
    private OrderItemId id;

    @MapsId("orderId")
    @ManyToOne(optional = false)
    @JoinColumn(
        name = "order_id",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_order_items_items")
    )
    private Order order;
    
    @MapsId("productId")
    @ManyToOne(optional = false)
    @JoinColumn(
        name = "product_id",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_order_items_products")
    )
    private Product product;
    
    @Column(nullable = false)
    private Integer quantity;
    
    @Column(nullable = false)
    private BigDecimal price;
}
