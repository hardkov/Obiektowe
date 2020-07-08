package pl.edu.agh.internetshop;

import java.math.BigDecimal;

public class Product {
	
	public static final int PRICE_PRECISION = 2;
	public static final int ROUND_STRATEGY = BigDecimal.ROUND_HALF_UP;
	
    private final String name;
    private final BigDecimal price;

    private double discount;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
        this.price.setScale(PRICE_PRECISION, ROUND_STRATEGY);
        this.discount = 0;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price.multiply(new BigDecimal(1-this.discount));
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        if(discount > 1 || discount < 0){
            throw new IllegalArgumentException();
        }

        this.discount = discount;
    }
}
