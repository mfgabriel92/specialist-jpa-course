package br.gabriel.jpaspecialist.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "card_payments")
@Getter
@Setter
public class CardPayment extends Payment {
    private String number;
}
