package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class ProductNameSearchStrategyTest {
    private Order getOrderWithCertainProductName(String name){
        Product product = mock(Product.class);
        given(product.getName()).willReturn(name);
        List<Product> products = new ArrayList<>();
        products.add(product);
        Order order = mock(Order.class);
        given(order.getProducts()).willReturn(products);
        return order;
    }

    @Test
    void testSearch(){
        //given
        ProductNameSearchStrategy productNameSearchStrategy = new ProductNameSearchStrategy("Marchewka");

        // when
        Order order1 = getOrderWithCertainProductName("Marchewka");
        Order order2 = getOrderWithCertainProductName("Ogorek");

        //then
        assertTrue(productNameSearchStrategy.filter(order1));
        assertFalse(productNameSearchStrategy.filter(order2));
    }
}
