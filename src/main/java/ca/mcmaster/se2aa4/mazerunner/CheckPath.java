package ca.mcmaster.se2aa4.mazerunner;

import java.awt.Point;

public class CheckPath {
    private Explorer explorer;
    private Maze maze;

    //constructor
    public CheckPath(Maze maze) {
        this.maze = maze;
        this.explorer = new Explorer(maze.getEntry(), 'E');
    }

    public boolean checkPath(String path) {
        //loop through each character in the path

        String expandedPath = expandPath(path);

        for (int i = 0; i < expandedPath.length(); i++) {
            char action = expandedPath.charAt(i);
            if (!doMove(action)) { //if the action is invalid, return false
                return false;
            }
        }

        //check if we made it to the exit
        return explorer.getPosition().equals(maze.getExit());
    }

    private boolean doMove(char action) {
        if (action == 'F') {
            // Check next position before moving
            Point nextPos = getNextPosition(explorer.getPosition(), explorer.getDirection());
            int row = nextPos.y - 1;
            int col = nextPos.x - 1;
            if (row < 0 || row >= maze.getHeight() || col < 0 || col >= maze.getWidth()) {
                return false;
            }
            if (!maze.isPassage(nextPos)) {
                return false;
            }
            explorer.moveForward();
        } else if (action == 'L') {
            explorer.turnLeft();
        } else if (action == 'R') {
            explorer.turnRight();
        } else {
            return false; // Invalid character
        }
        return true;
    }

    private Point getNextPosition(Point current, char direction) {
        Point next = new Point(current.x, current.y);
        if (direction == 'N') {
            next.y--; //move up
        } else if (direction == 'E') {
            next.x++; //move right  
        } else if (direction == 'S') {
            next.y++; //move down
        } else if (direction == 'W') {
            next.x--; //move left
        }
        return next;
    }

    // Expand a factorized path like "2L F 3R" to "LLFRRR"
    private String expandPath(String compressedPath) {
        StringBuilder expanded = new StringBuilder();
        String[] tokens = compressedPath.trim().split("\\s+");

        for (String token : tokens) {
            int i = 0;
            while (i < token.length() && Character.isDigit(token.charAt(i))) {
                i++;
            }

            int count = (i == 0) ? 1 : Integer.parseInt(token.substring(0, i));
            char move = token.charAt(i);

            for (int j = 0; j < count; j++) {
                expanded.append(move);
            }
        }

        return expanded.toString();
    }
}
