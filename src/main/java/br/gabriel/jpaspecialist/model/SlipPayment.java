package br.gabriel.jpaspecialist.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "slip_payments")
@Getter
@Setter
public class SlipPayment extends BaseEntity {
    @Column(name = "order_id")
    private Integer orderId;
    
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
    
    private String barCode;
}
