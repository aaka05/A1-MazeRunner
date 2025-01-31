package ca.mcmaster.se2aa4.mazerunner;

import java.awt.Point;

public class PathFinder {
    private final Maze maze;
    private final Explorer explorer;

    public PathFinder(Maze maze) {
        this.maze = maze;
        //set the explorer to the entry point and facing east
        this.explorer = new Explorer(maze.getEntry(), 'E'); 
    }

    //solve the maze
    public Path solve() {
        //while the explorer is not at the exit point
        while (!explorer.getPosition().equals(maze.getExit())) {
            //first try to turn right and move
            explorer.turnRight();
            Point rightPosition = getNextPosition(explorer.getPosition(), explorer.getDirection());
            
            if (isValidMove(rightPosition)) {
                //if move right is valid, move forward
                explorer.moveForward();
            } else {
                //if move right is not valid, turn back left and try moving forward
                explorer.turnLeft();
                Point forwardPosition = getNextPosition(explorer.getPosition(), explorer.getDirection());
                
                if (isValidMove(forwardPosition)) {
                    //if move forward is valid, move forward
                    explorer.moveForward();
                } else {
                    //if move forward is not valid, turn left and try again
                    explorer.turnLeft();
                }
            }
        }
        
        return explorer.getPath();
    }

    private Point getNextPosition(Point current, char direction) {
        Point next = new Point(current.x, current.y);
        if (direction == 'N') {
            next.y--;
        } else if (direction == 'E') {
            next.x++;
        } else if (direction == 'S') {
            next.y++;
        } else if (direction == 'W') {
            next.x--;
        }
        return next;
    }

    private boolean isValidMove(Point position) {
        //the position is 1-based, so we need to convert to 0-based indexing
        int row = position.y - 1;
        int col = position.x - 1;
        
        //check if position is within maze bounds
        if (row < 0 || row >= maze.getHeight() || col < 0 || col >= maze.getWidth()) {
            return false;
        }
        
        //make sure the position is not a wall
        return maze.isPassage(position);
    }
}