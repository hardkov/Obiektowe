package pl.edu.agh.internetshop;

import java.math.BigDecimal;

public class OrderPriceSearchStrategy implements SearchStrategy{
    private BigDecimal minPrice;
    private BigDecimal maxPrice;

    public OrderPriceSearchStrategy(BigDecimal minPrice, BigDecimal maxPrice){
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
    }

    @Override
    public boolean filter(Order order) {
        return order.getPriceWithTaxes().compareTo(minPrice) >= 0 && order.getPriceWithTaxes().compareTo(maxPrice) <= 0;
    }
}
