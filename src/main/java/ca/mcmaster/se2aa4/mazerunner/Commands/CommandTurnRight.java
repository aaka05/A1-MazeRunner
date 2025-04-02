package ca.mcmaster.se2aa4.mazerunner.Commands;

import ca.mcmaster.se2aa4.mazerunner.Explorer;

public class CommandTurnRight implements Command {
    private final Explorer explorer;

    public CommandTurnRight(Explorer explorer) {
        this.explorer = explorer;
    }

    public boolean execute() {
        explorer.turnRight();
        return true;
    }
}
