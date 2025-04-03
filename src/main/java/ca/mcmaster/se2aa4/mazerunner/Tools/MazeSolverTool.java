package ca.mcmaster.se2aa4.mazerunner.Tools;

import ca.mcmaster.se2aa4.mazerunner.Maze;
import ca.mcmaster.se2aa4.mazerunner.Path;
import ca.mcmaster.se2aa4.mazerunner.PathFinder;

//This is the solver tool that will solve the maze
public class MazeSolverTool implements MazeTool {
    private final Maze maze;

    public MazeSolverTool(Maze maze) {
        this.maze = maze;
    }

    @Override
    public void run() {
        PathFinder pathFinder = new PathFinder(maze);
        Path path = pathFinder.solve();
        System.out.println(path.getFactorizedPath());
    }
}
