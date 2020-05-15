package pl.agh.edu.dp.main;

import pl.agh.edu.dp.labirynth.*;

public class Main {

    public static void main(String[] args) {

        MazeGame mazeGame = new MazeGame();

        Maze maze = mazeGame.createMaze(new StandardBuilderMaze(), new BombedMazeFactory());
        Player player = new Player(50, 0, maze);

        System.out.println(mazeGame);
        mazeGame.gameLoop(player);

    }
}



