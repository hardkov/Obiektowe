package pl.agh.edu.dp.labirynth;

import java.awt.event.KeyEvent;
import java.util.Scanner;

public class MazeGame {
    public Maze createMaze(StandardBuilderMaze builder, MazeFactory mazeFactory){
        boolean buildWallSuccess = true;
        boolean buildDoorSuccess = true;

        builder.setFactory(mazeFactory);

        builder.buildRoom(); // 0
        builder.buildRoom(); // 1
        builder.buildRoom(); // 2

        // building non-common walls
        for(Direction dir: Direction.values()){
            buildWallSuccess &= builder.buildWall(0 , -1, dir);
            buildWallSuccess &= builder.buildWall(1 , -1, dir);
            buildWallSuccess &= builder.buildWall(2 , -1, dir);
        }

        // Overwriting common walls
        buildWallSuccess &= builder.buildWall(1 , 2, Direction.East);
        buildWallSuccess &= builder.buildWall(0 , 1, Direction.North);

        if(!buildWallSuccess) System.out.println("Wall building problems");

        buildDoorSuccess &= builder.buildDoor(0, 1);
        buildDoorSuccess &= builder.buildDoor(1, 2);

        if(!buildDoorSuccess) System.out.println("Door building problems");

        return builder.getMaze();
    }

    public void gameLoop(Player player){
        Scanner input = new Scanner(System.in);
        int move;
        boolean playingFlag = true;

        while(playingFlag){
            move = input.nextInt();

            switch(move){
                case 0:
                    player.move(Direction.West);
                    break;
                case 1:
                    player.move(Direction.North);
                    break;
                case 2:
                    player.move(Direction.East);
                    break;
                case 3:
                    player.move(Direction.South);
                    break;
                case -1:
                    playingFlag = false;
                    break;
                default:
                    continue;
            }

            if(player.getHp() <= 0){
                System.out.println("You died, game is closing");
                playingFlag = false;
            }
        }
    }

    @Override
    public String toString(){
        return "Use numbers to move, 0 - east, 1-north, 2-west, 3-south, -1 to leave game";
    }
}
