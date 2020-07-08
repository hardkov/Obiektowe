package pl.edu.agh.internetshop;

import java.util.List;

public class CompositeSearchStrategy implements SearchStrategy{
    private final List<SearchStrategy> strategies;

    public CompositeSearchStrategy(List<SearchStrategy> strategies){
        this.strategies = strategies;
    }

    @Override
    public boolean filter(Order order) {
        return strategies.stream().allMatch(strategy -> strategy.filter(order));
    }
}
