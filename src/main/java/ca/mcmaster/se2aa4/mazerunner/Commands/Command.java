package ca.mcmaster.se2aa4.mazerunner.Commands;

@FunctionalInterface
public interface Command {
    //returns true if the command is valid, false otherwise
    boolean execute();
}
