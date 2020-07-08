package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class OrderHistoryTest {
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
    public void searchTest(){
        //given
        OrderPriceSearchStrategy orderPriceSearchStrategy = new OrderPriceSearchStrategy(
                new BigDecimal(1), new BigDecimal(7));

        ClientNameSearchStrategy clientNameSearchStrategy = new ClientNameSearchStrategy(
                "Hardek");
        ProductNameSearchStrategy productNameSearchStrategy = new ProductNameSearchStrategy(
                "Marchewka");

        List<SearchStrategy> searchStrategies = new ArrayList<>();
        searchStrategies.add(orderPriceSearchStrategy);
        searchStrategies.add(clientNameSearchStrategy);
        searchStrategies.add(productNameSearchStrategy);

        CompositeSearchStrategy compositeSearchStrategy = new CompositeSearchStrategy(searchStrategies);

        Order order1 = getOrderWithCertainPriceAndNames(new BigDecimal(4), "Hardek", "Marchewka");
        Order order2 = getOrderWithCertainPriceAndNames(new BigDecimal(6), "Nowak", "Marchewka");
        Order order3 = getOrderWithCertainPriceAndNames(new BigDecimal(4), "Nowak", "Marchewka");
        Order order4 = getOrderWithCertainPriceAndNames(new BigDecimal(6), "Hardek", "Marchewka");
        Order order5 = getOrderWithCertainPriceAndNames(new BigDecimal(4), "Hardek", "Ogorek");
        Order order6 = getOrderWithCertainPriceAndNames(new BigDecimal(6), "Nowak", "Ogorek");
        Order order7 = getOrderWithCertainPriceAndNames(new BigDecimal(4), "Nowak", "Ogorek");
        Order order8 = getOrderWithCertainPriceAndNames(new BigDecimal(6), "Hardek", "Ogorek");

        //when
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.addOrder(order1);
        orderHistory.addOrder(order2);
        orderHistory.addOrder(order3);
        orderHistory.addOrder(order4);
        orderHistory.addOrder(order5);
        orderHistory.addOrder(order6);
        orderHistory.addOrder(order7);
        orderHistory.addOrder(order8);

        List<Order> expectedOrders = new ArrayList<>();
        expectedOrders.add(order1);
        expectedOrders.add(order4);

        //then
        assertEquals(expectedOrders, orderHistory.searchOrders(compositeSearchStrategy));
    }

    @Test
    public void listTest(){
        //given
        Order order1 = mock(Order.class);
        Order order2 = mock(Order.class);

        OrderHistory orderHistory = new OrderHistory();
        orderHistory.addOrder(order1);
        orderHistory.addOrder(order2);

        //when
        List<Order> expectedOrders = new ArrayList<>();
        expectedOrders.add(order1);
        expectedOrders.add(order2);

        //then
        assertEquals(expectedOrders, orderHistory.getOrders());
    }
}
