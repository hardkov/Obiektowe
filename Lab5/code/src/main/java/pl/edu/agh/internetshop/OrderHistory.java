package pl.edu.agh.internetshop;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderHistory {
    private List<Order> orders;

    public OrderHistory(){
        orders = new ArrayList<>();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    public List<Order> searchOrders(SearchStrategy strategy){
        return this.orders.stream().filter(order -> strategy.filter(order)).collect(Collectors.toList());
    }
}
