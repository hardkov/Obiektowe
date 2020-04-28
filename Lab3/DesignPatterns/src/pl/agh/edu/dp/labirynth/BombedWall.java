package pl.agh.edu.dp.labirynth;

public class BombedWall extends Wall{
    public BombedWall(){
        super();
    }

    @Override
    public void Enter(Player player){
        player.setHp(player.getHp()-5);
        System.out.printf("You lost 5hp on Wall, Current hp: %d\n", player.getHp());
    }
}
