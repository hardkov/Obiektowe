package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<SuspectAggregate> suspectAggregates = new ArrayList<>();
        suspectAggregates.add(new PersonDataProvider());
        suspectAggregates.add(new PrisonerDataProvider());
        suspectAggregates.add(new StudentDataProvider());
        CompositeAggregate compositeAggregate = new CompositeAggregate(suspectAggregates);
        Finder suspects = new Finder(compositeAggregate);

        List<SearchStrategy> strategyList = new ArrayList<>();
        strategyList.add(new NameSearchStrategy("Janusz"));
        strategyList.add(new AgeSearchStrategy(10, 30));
        CompositeSearchStrategy strategy = new CompositeSearchStrategy(strategyList);

        suspects.searchDisplay(strategy);
    }
}
