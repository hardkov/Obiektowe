package pl.agh.edu.dp.labirynth;

public class BombedRoom extends Room{
    public BombedRoom(int roomNo){
        super(roomNo);
    }

    @Override
    public void Enter(Player player){
        player.setCurrentRoom(this);
        System.out.printf("Current room: %d\n WALLS DO DMG\n", this.getRoomNumber());
    }
}
