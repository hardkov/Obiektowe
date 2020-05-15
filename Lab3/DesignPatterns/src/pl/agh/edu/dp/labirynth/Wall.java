package pl.agh.edu.dp.labirynth;

public class Wall extends MapSite {
    public Wall(){

    }

    @Override
    public void Enter(Player player){
        System.out.println("Can't walk into wall");
    }
}
