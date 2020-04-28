package pl.agh.edu.dp.labirynth;

public class EnchantedMazeFactory extends MazeFactory{

    @Override
    public Room makeRoom(int roomNo){
        return new EnchantedRoom(roomNo);
    }

    @Override
    public Wall makeWall(){
        return new EnchantedWall();
    }

    @Override
    public Door makeDoor(Room room1, Room room2){
        return new EnchantedDoor(room1, room2);
    }
}
