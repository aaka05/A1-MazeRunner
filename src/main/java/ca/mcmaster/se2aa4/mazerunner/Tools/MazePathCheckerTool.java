package ca.mcmaster.se2aa4.mazerunner.Tools;

import ca.mcmaster.se2aa4.mazerunner.CheckPath;
import ca.mcmaster.se2aa4.mazerunner.Maze;

public class MazePathCheckerTool implements MazeTool {
    private final Maze maze;
    private final String path;

    public MazePathCheckerTool(Maze maze, String path) {
        this.maze = maze;
        this.path = path;
    }   

    @Override
    public void run() {
        CheckPath pathChecker = new CheckPath(maze);
        boolean isValid = pathChecker.checkPath(path);
        if (isValid) {
            System.out.println("Path is valid");
        } else {
            System.out.println("Path is invalid");
        }
    }
}