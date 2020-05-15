package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Collectors;

public class StudentDataProvider implements SuspectAggregate{

    private final Collection<Student> studentCitizens = new ArrayList<Student>();

    public StudentDataProvider() {
        studentCitizens.add(new Student("Krzyszof", "Byk", 24, "213971"));
        studentCitizens.add(new Student("Adrian", "Slon", 24, "123013"));
        studentCitizens.add(new Student("Mariusz", "Paper", 24, "123123"));
        studentCitizens.add(new Student("Piotr", "Noszka", 24, "123791"));
        studentCitizens.add(new Student("Janusz", "Dyszka", 24, "123981"));
        studentCitizens.add(new Student("Marta", "Pech", 24, "123712"));
        studentCitizens.add(new Student("Halina", "Pomidor",19, "123971"));
        studentCitizens.add(new Student("Janusz", "Kij", 31, "721231"));
        studentCitizens.add(new Student("Kacper", "Muchomor", 30, "731811"));
        studentCitizens.add(new Student("Mateusz", "Zebra", 21, "890312"));
        studentCitizens.add(new Student("Dominik", "Zupa", 20, "235141"));
    }

    public Collection<Student> getAllstudentCitizens() {
        return studentCitizens;
    }

    @Override
    public Iterator<Suspect> iterator() {
        Collection<Suspect> suspects = this.studentCitizens.stream().map(cc -> (Suspect) cc).collect(Collectors.toList());
        return suspects.iterator();
    }
}

