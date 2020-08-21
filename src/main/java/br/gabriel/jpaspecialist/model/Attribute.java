package br.gabriel.jpaspecialist.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Attribute {
    @Column(length = 25, nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String value;
}
