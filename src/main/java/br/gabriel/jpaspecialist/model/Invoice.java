package br.gabriel.jpaspecialist.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "invoices")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Invoice {
    @Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String xml;
    
    @OneToOne(optional = false)
    @JoinColumn(name = "order_id")
    private Order order;
    
    @Column(name = "created_at")
    private Date createdAt;
}
