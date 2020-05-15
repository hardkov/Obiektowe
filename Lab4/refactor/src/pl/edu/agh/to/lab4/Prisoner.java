package pl.edu.agh.to.lab4;

import java.util.Calendar;

public class Prisoner extends Suspect{
    private final int judgementYear;

    private final int senteceDuration;

    private final String pesel;

    private final int age;

    public Prisoner(String name, String surname, int age, String pesel, int judgementYear, int sentenceDuration) {
        super(name, surname);
        this.pesel = pesel;
        this.judgementYear = judgementYear;
        this.senteceDuration = sentenceDuration;
        this.age = age;
    }

    @Override
    public boolean canBeAccused() {
        return !isJailedNow();
    }

    @Override
    public int getAge() {
        return age;
    }

    public String getPesel() {
        return pesel;
    }

    public int getJudgementYear() {
        return judgementYear;
    }

    public int getSenteceDuration() {
        return senteceDuration;
    }

    public boolean isJailedNow() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return judgementYear + senteceDuration >= currentYear;
    }
}
