package br.gabriel.jpaspecialist.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrderItem {
    @Id
    @Include
    private Integer id;
    
    @Column(name = "order_id")
    private Integer orderId;
    
    @Column(name = "product_id")
    private Integer productId;
    
    private Integer quantity;
    
    private BigDecimal price;
}
