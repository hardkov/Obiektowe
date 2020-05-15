package pl.agh.edu.dp.labirynth;

public class MazeFactory {
    private static MazeFactory instance;

    public static MazeFactory getInstance(){
        if(instance == null){
            instance = new MazeFactory();         // singleton mechanism
        }
        return instance;
    }

    public Room makeRoom(int roomNo){
        return new Room(roomNo);
    }

    public Wall makeWall(){
        return new Wall();
    }

    public Door makeDoor(Room room1, Room room2){
        return new Door(room1, room2);
    }
}
