package br.gabriel.jpaspecialist.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("card")
@Getter
@Setter
public class CardPayment extends Payment {
    @Column(length = 16, nullable = false)
    private String number;
}
