package br.gabriel.jpaspecialist.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;

import javax.persistence.*;

@Entity
@Table(name = "clients")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Client {
    @Id
    @Include
    private Integer id;
    
    private String name;
    
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
