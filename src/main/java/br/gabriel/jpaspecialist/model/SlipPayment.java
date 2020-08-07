package br.gabriel.jpaspecialist.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "slip_payments")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SlipPayment {
    @Id
    @Include
    private Integer id;
    
    @Column(name = "order_id")
    private Integer orderId;
    
    private PaymentStatus status;
    
    private String barCode;
}
