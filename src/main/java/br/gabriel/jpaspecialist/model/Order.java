package br.gabriel.jpaspecialist.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Order {
    @Id
    @Include
    private Integer id;
    
    private Integer invoiceId;
    
    private BigDecimal total;
    
    private OrderStatus status;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime concludedAt;
}
