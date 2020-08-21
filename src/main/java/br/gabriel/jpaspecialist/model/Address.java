package br.gabriel.jpaspecialist.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Address {
    @Column(name = "postal_code", length = 9)
    private String postalCode;
    
    @Column(length = 50)
    private String street;
    
    @Column(length = 5)
    private String number;
    
    @Column(length = 5)
    private String apartment;
    
    @Column(length = 50)
    private String neighborhood;
    
    @Column(length = 25)
    private String city;
    
    @Column(length = 2)
    private String state;
}
