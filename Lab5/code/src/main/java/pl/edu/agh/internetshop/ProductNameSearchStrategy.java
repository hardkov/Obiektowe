package pl.edu.agh.internetshop;

public class ProductNameSearchStrategy implements SearchStrategy{
    private String name;

    public ProductNameSearchStrategy(String name){
        this.name = name;
    }

    @Override
    public boolean filter(Order order) {
        return order.getProducts().stream().anyMatch(product -> product.getName().equals(name));
    }
}
