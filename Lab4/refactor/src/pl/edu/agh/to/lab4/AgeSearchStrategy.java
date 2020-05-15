package pl.edu.agh.to.lab4;

public class AgeSearchStrategy implements SearchStrategy{
    private final int minAge;
    private final int maxAge;

    public AgeSearchStrategy(int minAge, int maxAge){
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    @Override
    public boolean filter(Suspect suspect) {
        return suspect.getAge() >= minAge && suspect.getAge() <= maxAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public int getMinAge() {
        return minAge;
    }
}
