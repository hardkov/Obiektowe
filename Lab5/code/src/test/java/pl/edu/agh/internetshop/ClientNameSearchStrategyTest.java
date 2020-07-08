package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class ClientNameSearchStrategyTest {

    private Order getOrderWithCertainClientName(String name){
        Address address = mock(Address.class);
        given(address.getName()).willReturn(name);
        Shipment shipment = mock(Shipment.class);
        given(shipment.getRecipientAddress()).willReturn(address);
        Order order = mock(Order.class);
        given(order.getShipment()).willReturn(shipment);
        return order;
    }

    @Test
    void testSearch(){
        //given
        ClientNameSearchStrategy clientNameSearchStrategy = new ClientNameSearchStrategy("Hardek");

        // when
        Order order1 = getOrderWithCertainClientName("Hardek");
        Order order2 = getOrderWithCertainClientName("Nowak");

        //then
        assertTrue(clientNameSearchStrategy.filter(order1));
        assertFalse(clientNameSearchStrategy.filter(order2));
    }
}
