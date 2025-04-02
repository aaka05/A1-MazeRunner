package ca.mcmaster.se2aa4.mazerunner;

import java.util.Map;
import java.util.function.Supplier;

import ca.mcmaster.se2aa4.mazerunner.Commands.Command;
import ca.mcmaster.se2aa4.mazerunner.Commands.CommandMoveForward;
import ca.mcmaster.se2aa4.mazerunner.Commands.CommandTurnLeft;
import ca.mcmaster.se2aa4.mazerunner.Commands.CommandTurnRight;

public class CommandFactory {
    private final Map<Character, Supplier<Command>> commandMap;

    public CommandFactory(Explorer explorer, Maze maze) {
        commandMap = Map.of(
            'F', () -> new CommandMoveForward(explorer, maze),
            'L', () -> new CommandTurnLeft(explorer),
            'R', () -> new CommandTurnRight(explorer)
        );
    }

    public Command getCommand(char action) {
        Supplier<Command> supplier = commandMap.get(action);
        return supplier != null ? supplier.get() : null;
    }
}