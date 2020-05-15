package pl.edu.agh.to.lab4;

import java.util.List;

public class CompositeSearchStrategy implements SearchStrategy{
    private List<SearchStrategy> searchStrategyList;

    public CompositeSearchStrategy(List<SearchStrategy> searchStrategyList){
        this.searchStrategyList = searchStrategyList;
    }

    @Override
    public boolean filter(Suspect suspect) {
        for(SearchStrategy s : searchStrategyList){
            if(!s.filter(suspect)) return false;
        }

        return true;
    }
}
