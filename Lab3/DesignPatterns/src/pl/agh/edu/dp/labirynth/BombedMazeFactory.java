package pl.agh.edu.dp.labirynth;

public class BombedMazeFactory extends MazeFactory{

    @Override
    public Room makeRoom(int roomNo){
        return new BombedRoom(roomNo);
    }

    @Override
    public Wall makeWall(){
        return new BombedWall();
    }

}
