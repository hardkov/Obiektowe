package pl.agh.edu.dp.labirynth;

public interface MazeBuilder {
    public abstract void reset();

    public abstract boolean buildDoor(int roomNo1, int roomNo2);

    public abstract int buildRoom();

    public abstract boolean buildWall(int roomNo1, int roomNo2, Direction dirRoom1);
}
