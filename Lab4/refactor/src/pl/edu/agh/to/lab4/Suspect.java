package pl.edu.agh.to.lab4;

public abstract class Suspect {
    private final String name;
    private final String surname;

    protected Suspect(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public abstract boolean canBeAccused();

    public abstract int getAge();

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return this.getName() + " " + this.getSurname();
    }
}