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
            Point nextPos = getNextPosition(explorer.getPosition(), explorer.getDirection());
            
            if (canMoveTo(nextPos)) {
                //if move right is valid, move forward
                explorer.moveForward();  
            } else {
                explorer.turnLeft();  //go back to original direction
                nextPos = getNextPosition(explorer.getPosition(), explorer.getDirection());
                
                if (canMoveTo(nextPos)) {
                    explorer.moveForward(); //if move forward is valid, move forward
                } else {
                    explorer.turnLeft(); //try another direction next time
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

    
    private boolean canMoveTo(Point position) {
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