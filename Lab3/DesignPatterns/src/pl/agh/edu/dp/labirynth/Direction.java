package pl.agh.edu.dp.labirynth;

public enum Direction {
    North, South, East, West;

    public static Direction opposite(Direction dir){
        switch(dir){
            case North:
                return South;
            case South:
                return North;
            case East:
                return West;
            case West:
                return East;
            default:
                return null;
        }
    }
}