package br.gabriel.jpaspecialist.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("slip")
@Getter
@Setter
public class SlipPayment extends Payment {
    private String barCode;
}
