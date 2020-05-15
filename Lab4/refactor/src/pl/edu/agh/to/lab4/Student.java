package pl.edu.agh.to.lab4;

public class Student extends Suspect{
    private String index;

    private final int age;

    public Student(String name, String surname, int age, String index){
        super(name, surname);
        this.index = index;
        this.age = age;
    }

    @Override
    public boolean canBeAccused() {
        return this.age >= 18;
    }

    @Override
    public int getAge() {
        return age;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
}
