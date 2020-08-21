package br.gabriel.jpaspecialist.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order extends BaseEntity {
    @OneToOne(mappedBy = "order")
    private Invoice invoice;
    
    @Column(nullable = false)
    private BigDecimal total;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)
    private OrderStatus status;
    
    @ManyToOne(optional = false)
    @JoinColumn(
        name = "client_id",
        foreignKey = @ForeignKey(name = "fk_orders_clients")
    )
    private Client client;
    
    @OneToMany(mappedBy = "order")
    private List<OrderItem> items;
    
    @OneToOne(mappedBy = "order")
    private Payment payment;
    
    @Column(name = "concluded_at")
    private LocalDateTime concludedAt;
    
    @Embedded
    private Address address;
    
    public Boolean isPaid() {
        return OrderStatus.PAID.equals(getStatus());
    }
    
    public Boolean hasInvoice() {
        return getInvoice() != null;
    }
    
    @PrePersist
    @PreUpdate
    private void calculateTotal() {
        if (items != null) {
            total = items.stream().map(OrderItem::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        }
    }
}

