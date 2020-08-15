package br.gabriel.jpaspecialist.advancedmapping;

import br.gabriel.jpaspecialist.BaseEntityManager;
import br.gabriel.jpaspecialist.model.Invoice;
import br.gabriel.jpaspecialist.model.Order;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class LobPropertyTest extends BaseEntityManager {
    @Test
    public void shouldTestLobProperty() {
        Order order = find(Order.class, 1);
    
        Invoice invoice = new Invoice();
        invoice.setOrder(order);
        invoice.setXml(loadInvoice());
        
        persist(invoice);
        
        Invoice assertInvoice = find(Invoice.class, invoice.getId());
        Assert.assertNotNull(assertInvoice.getXml());
        Assert.assertTrue(assertInvoice.getXml().length > 0);
    }
    
    private static byte[] loadInvoice() {
        try {
            return LobPropertyTest.class.getResourceAsStream("/invoice.xml").readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
