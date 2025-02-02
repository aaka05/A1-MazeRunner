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

        for (int i = 0; i < path.length(); i++) {
            char action = path.charAt(i);
            if (!doMove(action)) { //if the action is invalid, return false
                return false;
            }
        }
        
        //check if we made it to the exit
        return explorer.getPosition().equals(maze.getExit());
    }

    private boolean doMove(char action) {
        if (action == 'F') {
            //check if we can move forward
            Point nextPos = getNextPosition(explorer.getPosition(), explorer.getDirection());
            //if the next position is not a passage, return false
            if (!maze.isPassage(nextPos)) {
                return false;
            }
            explorer.moveForward();
        } else if (action == 'L') {
         
            explorer.turnLeft();
        } else if (action == 'R') {
            explorer.turnRight();
        } else {
            return false;
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
} 