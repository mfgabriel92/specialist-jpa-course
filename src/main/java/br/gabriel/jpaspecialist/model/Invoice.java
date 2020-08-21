package br.gabriel.jpaspecialist.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "invoices")
@Getter
@Setter
public class Invoice extends BaseEntity {
    @Lob
    @Column(nullable = false)
    private byte[] xml;
    
    @MapsId
    @OneToOne(optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
}
