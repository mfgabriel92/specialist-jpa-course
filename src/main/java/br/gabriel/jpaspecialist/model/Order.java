package br.gabriel.jpaspecialist.model;

import br.gabriel.jpaspecialist.listener.GenerateInvoiceListener;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@EntityListeners({GenerateInvoiceListener.class})
public class Order {
    @Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @OneToOne(mappedBy = "order")
    private Invoice invoice;
    
    private BigDecimal total;
    
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id")
    private Client client;
    
    @OneToMany(mappedBy = "order")
    private List<OrderItem> items;
    
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at", insertable = false)
    private LocalDateTime updatedAt;
    
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
    public void prePersist() {
        setCreatedAt(LocalDateTime.now());
        calculateTotal();
    }
    
    @PreUpdate
    public void preUpdate() {
        setUpdatedAt(LocalDateTime.now());
        calculateTotal();
    }
    
    private void calculateTotal() {
        if (items != null) {
            total = items.stream().map(OrderItem::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        }
    }
}

