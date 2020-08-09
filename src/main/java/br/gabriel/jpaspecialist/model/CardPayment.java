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
    
    @Column(name = "order_id")
    private Integer orderId;
    
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
    
    private String number;
}
