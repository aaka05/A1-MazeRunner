package ca.mcmaster.se2aa4.mazerunner;

import java.util.Map;
import java.util.function.Supplier;

import ca.mcmaster.se2aa4.mazerunner.Commands.Command;
import ca.mcmaster.se2aa4.mazerunner.Commands.CommandMoveForward;
import ca.mcmaster.se2aa4.mazerunner.Commands.CommandTurnLeft;
import ca.mcmaster.se2aa4.mazerunner.Commands.CommandTurnRight;

public class CommandFactory {
    private final Explorer explorer;
    private final Maze maze;

    public CommandFactory(Explorer explorer, Maze maze) {
        this.explorer = explorer;
        this.maze = maze;
    }

    public Command getCommand(char action) {
        if (action == 'F') {
            return new CommandMoveForward(explorer, maze);
        } else if (action == 'L') {
            return new CommandTurnLeft(explorer);
        } else if (action == 'R') {
            return new CommandTurnRight(explorer);
        } else {
            return null;
        }
    }
}