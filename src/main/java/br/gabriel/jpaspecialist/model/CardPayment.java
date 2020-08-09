package br.gabriel.jpaspecialist.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;

import javax.persistence.*;

@Entity
@Table(name = "card_payments")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CardPayment {
    @Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @OneToOne(optional = false)
    @JoinColumn(name = "order_id")
    private Order order;
    
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
    
    private String number;
}
