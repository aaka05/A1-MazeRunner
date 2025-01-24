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
    public String solve() {
        //while the explorer is not at the exit point
        while (!explorer.getPosition().equals(maze.getExit())) {
            //turn right
            explorer.turnRight();
            //get the next position 
            Point nextPosition = getNextPosition(explorer.getPosition(), explorer.getDirection());
            
            //if the next position is not a valid move
            if (!isValidMove(nextPosition)) {
                //turn left
                explorer.turnLeft();
                nextPosition = getNextPosition(explorer.getPosition(), explorer.getDirection());
                
                //if the next position is not a valid move
                if (!isValidMove(nextPosition)) {
                    //turn left
                    explorer.turnLeft();
                    nextPosition = getNextPosition(explorer.getPosition(), explorer.getDirection());
                    
                    if (!isValidMove(nextPosition)) {
                        //can't go left either, turn left one more time (reverse direction)
                        explorer.turnLeft();
                    }
                }
            }
            //move forward
            explorer.moveForward();
        }
        
        return String.join("", explorer.getPath().getPath());
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