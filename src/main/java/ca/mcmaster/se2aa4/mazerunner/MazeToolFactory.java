package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.Tools.MazePathCheckerTool;
import ca.mcmaster.se2aa4.mazerunner.Tools.MazeSolverTool;
import ca.mcmaster.se2aa4.mazerunner.Tools.MazeTool;

public class MazeToolFactory {
    public static MazeTool createTool(Maze maze, String path) {
        //if the path is provided, create a path checker tool
        if(path != null && !path.isEmpty()) {
            return new MazePathCheckerTool(maze, path);
        } else {
            //otherwise, create a solver tool
            return new MazeSolverTool(maze);
        }
    }
}