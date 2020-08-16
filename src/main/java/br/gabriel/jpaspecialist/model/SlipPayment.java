package br.gabriel.jpaspecialist.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("slip")
@Table(name = "slip_payments")
@Getter
@Setter
public class SlipPayment extends Payment {
    private String barCode;
}
