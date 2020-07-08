package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class OrderPriceSearchStrategyTest {
    private Order getOrderWithCertainPrice(BigDecimal price){
        Order order = mock(Order.class);
        given(order.getPriceWithTaxes()).willReturn(price);
        return order;
    }

    @Test
    void testSearch(){
        //given
        OrderPriceSearchStrategy orderPriceSearchStrategy = new OrderPriceSearchStrategy(
                new BigDecimal(1), new BigDecimal(5));

        // when
        Order order1 = getOrderWithCertainPrice(new BigDecimal(4));
        Order order2 = getOrderWithCertainPrice(new BigDecimal(6));

        //then
        assertTrue(orderPriceSearchStrategy.filter(order1));
        assertFalse(orderPriceSearchStrategy.filter(order2));
    }
}
