package ca.mcmaster.se2aa4.mazerunner.Commands;

import java.awt.Point;
import java.util.Map;

import ca.mcmaster.se2aa4.mazerunner.Explorer;
import ca.mcmaster.se2aa4.mazerunner.Maze;

public class CommandMoveForward implements Command {
    private final Explorer explorer;
    private final Maze maze;

    private static final Map<Character, Point> DELTAS = Map.of(
        'N', new Point(0, -1),
        'E', new Point(1, 0),
        'S', new Point(0, 1),
        'W', new Point(-1, 0)
    );

    public CommandMoveForward(Explorer explorer, Maze maze) {
        this.explorer = explorer;
        this.maze = maze;
    }

    public boolean execute() {
        Point current = explorer.getPosition();
        Point delta = DELTAS.get(explorer.getDirection());
        if (delta == null) return false;

        Point next = new Point(current.x + delta.x, current.y + delta.y);
        int row = next.y - 1;
        int col = next.x - 1;

        if (row < 0 || row >= maze.getHeight() || col < 0 || col >= maze.getWidth()) return false;
        if (!maze.isPassage(next)) return false;

        explorer.moveForward();
        return true;
    }
}
