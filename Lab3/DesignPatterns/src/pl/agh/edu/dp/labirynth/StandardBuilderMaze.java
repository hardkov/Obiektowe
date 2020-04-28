package pl.agh.edu.dp.labirynth;

public class StandardBuilderMaze implements MazeBuilder{
    private Maze currentMaze;
    private MazeFactory factory;

    public StandardBuilderMaze(MazeFactory factory){
        this.factory = factory;
        this.reset();
    }

    public StandardBuilderMaze(){
        this.reset();
    }

    @Override
    public void reset(){
        this.currentMaze = new Maze();
    }

    @Override
    public boolean buildDoor(int roomNo1, int roomNo2){
        Room room1 = currentMaze.getRoom(roomNo1);
        Room room2 = currentMaze.getRoom(roomNo2);

        Direction commonDir = this.commonWall(room1, room2);

        if(commonDir != null){
            Door newDoor = this.factory.makeDoor(room1, room2);//new Door(room1, room2);
            room1.setSide(commonDir, newDoor);
            room2.setSide(Direction.opposite(commonDir), newDoor);
            return true;
        }

        return false;
    }

    @Override
    public int buildRoom(){
        int newRoomNumber = this.currentMaze.getRoomNumbers();
        Room newRoom = this.factory.makeRoom(newRoomNumber);//new Room(newRoomNumber);

        currentMaze.addRoom(newRoom);

        return newRoomNumber;
    }

    @Override
    public boolean buildWall(int roomNo1, int roomNo2, Direction dirRoom1){
        // use roomNo2 = -1 to build wall only in room1
        Room room1 = currentMaze.getRoom(roomNo1);
        Room room2 = currentMaze.getRoom(roomNo2);
        Wall wall = this.factory.makeWall();//new Wall();

        if(room1 != null){
            room1.setSide(dirRoom1, wall);
        }

        if(room2 != null){
            room2.setSide(Direction.opposite(dirRoom1), wall);
        }

        return room1 != null || room2 != null;
    }

    private Direction commonWall(Room room1, Room room2){
        Direction commonDir = null;

        for(Direction dir: Direction.values()){
            if(room1.getSide(dir) == room2.getSide(Direction.opposite(dir))){
                commonDir = dir;
            }
        }

        return commonDir;
    }

    public Maze getMaze(){
        Maze maze = this.currentMaze;
        this.reset();
        return maze;
    }

    public void setFactory(MazeFactory factory){ this.factory = factory; }
}
