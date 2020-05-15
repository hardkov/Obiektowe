package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class Finder {
    private CompositeAggregate compositeAggregate;

    public Finder(CompositeAggregate compositeAggregate) {
        this.compositeAggregate = compositeAggregate;
    }

    public void searchDisplay(SearchStrategy strategy) {
        Suspect sTmp;
        ArrayList<Suspect> suspects = new ArrayList<>();

        Iterator<Suspect> suspectIterator = compositeAggregate.iterator();

        while(suspectIterator.hasNext()){
            sTmp = suspectIterator.next();

            if(strategy.filter(sTmp)) suspects.add(sTmp);
        }

        for(Suspect s : suspects){
            System.out.println(s);
        }
    }
}
