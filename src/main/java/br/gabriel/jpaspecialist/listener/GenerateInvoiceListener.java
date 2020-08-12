package br.gabriel.jpaspecialist.listener;

import br.gabriel.jpaspecialist.model.Order;
import br.gabriel.jpaspecialist.service.InvoiceService;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class GenerateInvoiceListener {
    private final InvoiceService invoiceService;
    
    public GenerateInvoiceListener() {
        this.invoiceService = new InvoiceService();
    }
    
    @PrePersist
    @PreUpdate
    public void generate(Order order) {
        if (order.isPaid() && !order.hasInvoice()) {
            invoiceService.generate(order);
        }
    }
}
