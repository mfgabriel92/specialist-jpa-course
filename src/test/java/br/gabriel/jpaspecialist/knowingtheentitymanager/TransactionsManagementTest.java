package br.gabriel.jpaspecialist.knowingtheentitymanager;

import br.gabriel.jpaspecialist.BaseEntityManager;
import br.gabriel.jpaspecialist.model.Order;
import br.gabriel.jpaspecialist.model.OrderStatus;
import org.junit.Test;

public class TransactionsManagementTest extends BaseEntityManager {
    @Test(expected = Exception.class)
    public void shouldTestTransactionManagement() {
        try {
            begin();
            businessLogic();
            commit();
        } catch (Exception e) {
            rollback();
            throw e;
        }
    }
    
    private void businessLogic() {
        Order order = find(Order.class, 1);
        order.setStatus(OrderStatus.PAID);
        
        if (order.getInvoice() != null) {
            throw new RuntimeException("Already paid");
        }
    }
}
