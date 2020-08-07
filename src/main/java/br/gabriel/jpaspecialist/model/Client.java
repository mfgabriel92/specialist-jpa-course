package br.gabriel.jpaspecialist.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
@Data
@EqualsAndHashCode(of = "id")
public class Client {
    @Id
    private Integer id;
    
    private String name;
}
