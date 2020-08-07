package br.gabriel.jpaspecialist.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "invoices")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Invoice {
    @Id
    @Include
    private Integer id;
    
    private Integer orderId;
    
    private String xml;
    
    private Date creatdAt;
}
