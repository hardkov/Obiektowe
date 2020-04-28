package pl.agh.edu.dp.labirynth;

public class CountingMazeBuilder implements MazeBuilder{
    int wallCount;
    int doorCount;
    int roomCount;

    public CountingMazeBuilder(){
        this.reset();
    }

    @Override
    public void reset(){
        this.wallCount = 0;
        this.doorCount = 0;
        this.roomCount = 0;
    }

    @Override
    public int buildRoom(){
        this.roomCount++;

        return -1;
    }

    @Override
    public boolean buildDoor(int roomNo1, int roomNo2){
        this.wallCount -= 2;
        this.doorCount += 1;
        return true;
    }

    @Override
    public boolean buildWall(int roomNo1, int roomNo2, Direction dir){
        if(roomNo1 != -1) wallCount++;
        if(roomNo2 != -1) wallCount++;

        return true;
    }

    public int getWallCount(){
        return wallCount;
    }

    public int getDoorCount(){
        return doorCount;
    }

    public int getRoomCount(){
        return roomCount;
    }

}
