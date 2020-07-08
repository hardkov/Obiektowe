package pl.edu.agh.internetshop;

public class ClientNameSearchStrategy implements SearchStrategy{
    private String name;

    public ClientNameSearchStrategy(String name){
        this.name = name;
    }

    @Override
    public boolean filter(Order order) {
        return order.getShipment().getRecipientAddress().getName().equals(name);
    }
}
