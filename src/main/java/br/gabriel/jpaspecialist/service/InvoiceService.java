package br.gabriel.jpaspecialist.service;

import br.gabriel.jpaspecialist.model.Order;

public class InvoiceService {
    public void generate(Order order) {
        System.out.println("Generating invoice for order #" + order.getId());
    }
}
