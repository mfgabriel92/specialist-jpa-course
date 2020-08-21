package br.gabriel.jpaspecialist.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "payments")
@DiscriminatorColumn(name = "payment_type")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
public abstract class Payment extends BaseEntity {
    @MapsId
    @OneToOne(optional = false)
    @JoinColumn(
        name = "order_id",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_payments_orders")
    )
    private Order order;
    
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
}
