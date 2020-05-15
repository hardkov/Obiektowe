package pl.edu.agh.to.lab4;

public class Person extends Suspect{
    private final int age;

    public Person(String name, String surname, int age) {
        super(name, surname);
        this.age = age;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public boolean canBeAccused() {
        return this.getAge() >= 18;
    }
}
