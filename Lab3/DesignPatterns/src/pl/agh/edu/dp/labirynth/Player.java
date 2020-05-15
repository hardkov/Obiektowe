package pl.agh.edu.dp.labirynth;

public class Player {
    private Room currentRoom;
    private int hp;
    private Maze currentMaze;

    public Player(int basicHp, int startingRoomNo, Maze currentMaze){
        this.hp = basicHp;
        this.currentMaze = currentMaze;
        this.currentRoom = this.currentMaze.getRoom(startingRoomNo);
    }

    public void move(Direction dir){
        MapSite side = currentRoom.getSide(dir);

        if(side instanceof Wall){
            side.Enter(this);
        }
        else if(side instanceof Door){
            side.Enter(this);
        }
        else if(side instanceof Room){
            side.Enter(this);
        }
        else if(side == null){
            System.out.println("Side undefined");
        }
        else{
            System.out.println("Unknown side");
        }
    }

    public Room getCurrentRoom(){
        return this.currentRoom;
    }

    public void setCurrentRoom(Room room){
        this.currentRoom = room;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp(){
        return this.hp;
    }

    public Maze getCurrentMaze() {
        return currentMaze;
    }
}
