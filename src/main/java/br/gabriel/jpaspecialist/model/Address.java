package br.gabriel.jpaspecialist.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Address {
    @Column(name = "postal_code")
    private String postalCode;
    
    private String street;
    
    private String number;
    
    private String apartment;
    
    private String neighborhood;
    
    private String city;
    
    private String state;
}
