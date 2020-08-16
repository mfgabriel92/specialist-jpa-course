package br.gabriel.jpaspecialist.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("card")
@Table(name = "card_payments")
@Getter
@Setter
public class CardPayment extends Payment {
    private String number;
}
