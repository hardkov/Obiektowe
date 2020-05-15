package pl.edu.agh.to.lab4;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CompositeAggregate implements SuspectAggregate {
    private List<SuspectAggregate> suspectAggregates;

    public CompositeAggregate(List<SuspectAggregate> suspectAggregates){
        this.suspectAggregates = suspectAggregates;
    }

    public Iterator<Suspect> iterator(){
        return suspectAggregates.stream().flatMap(aggr -> StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(
                        aggr.iterator(), Spliterator.ORDERED), false)).collect(Collectors.toList()).iterator();
    }
}
