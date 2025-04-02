package ca.mcmaster.se2aa4.mazerunner.Commands;

import ca.mcmaster.se2aa4.mazerunner.Explorer;

public class CommandTurnLeft implements Command {
    private final Explorer explorer;

    public CommandTurnLeft(Explorer explorer) {
        this.explorer = explorer;
    }

    public boolean execute() {
        explorer.turnLeft();
        return true;
    }
    
}