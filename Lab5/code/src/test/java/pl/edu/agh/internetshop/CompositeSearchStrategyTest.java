package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class CompositeSearchStrategyTest {
    private Order getOrderWithCertainPriceAndNames(BigDecimal price, String clientName, String productName){
        Address address = mock(Address.class);
        given(address.getName()).willReturn(clientName);
        Shipment shipment = mock(Shipment.class);
        given(shipment.getRecipientAddress()).willReturn(address);
        List<Product> products = new ArrayList<>();
        Product product = mock(Product.class);
        given(product.getName()).willReturn(productName);
        products.add(product);
        Order order = mock(Order.class);
        given(order.getShipment()).willReturn(shipment);
        given(order.getPriceWithTaxes()).willReturn(price);
        given(order.getProducts()).willReturn(products);
        return order;
    }

    @Test
    void testSearch(){
        //given
        OrderPriceSearchStrategy orderPriceSearchStrategy = new OrderPriceSearchStrategy(
                new BigDecimal(1), new BigDecimal(5));

        ClientNameSearchStrategy clientNameSearchStrategy = new ClientNameSearchStrategy(
                "Hardek");
        ProductNameSearchStrategy productNameSearchStrategy = new ProductNameSearchStrategy(
                "Marchewka");

        List<SearchStrategy> searchStrategies = new ArrayList<>();
        searchStrategies.add(orderPriceSearchStrategy);
        searchStrategies.add(clientNameSearchStrategy);
        searchStrategies.add(productNameSearchStrategy);

        CompositeSearchStrategy compositeSearchStrategy = new CompositeSearchStrategy(searchStrategies);

        // when
        Order order1 = getOrderWithCertainPriceAndNames(new BigDecimal(4), "Hardek", "Marchewka");
        Order order2 = getOrderWithCertainPriceAndNames(new BigDecimal(6), "Nowak", "Marchewka");
        Order order3 = getOrderWithCertainPriceAndNames(new BigDecimal(4), "Nowak", "Marchewka");
        Order order4 = getOrderWithCertainPriceAndNames(new BigDecimal(6), "Hardek", "Marchewka");
        Order order5 = getOrderWithCertainPriceAndNames(new BigDecimal(4), "Hardek", "Ogorek");
        Order order6 = getOrderWithCertainPriceAndNames(new BigDecimal(6), "Nowak", "Ogorek");
        Order order7 = getOrderWithCertainPriceAndNames(new BigDecimal(4), "Nowak", "Ogorek");
        Order order8 = getOrderWithCertainPriceAndNames(new BigDecimal(6), "Hardek", "Ogorek");

        //then
        assertTrue(compositeSearchStrategy.filter(order1));
        assertFalse(compositeSearchStrategy.filter(order2));
        assertFalse(compositeSearchStrategy.filter(order3));
        assertFalse(compositeSearchStrategy.filter(order4));
        assertFalse(compositeSearchStrategy.filter(order5));
        assertFalse(compositeSearchStrategy.filter(order6));
        assertFalse(compositeSearchStrategy.filter(order7));
        assertFalse(compositeSearchStrategy.filter(order8));
    }
}
