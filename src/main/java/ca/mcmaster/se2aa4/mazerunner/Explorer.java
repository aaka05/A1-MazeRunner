package ca.mcmaster.se2aa4.mazerunner;

import java.awt.Point;

public class Explorer {
    private Point position;
    private char direction; 
    private Path path;
    
    //constructor
    public Explorer(Point position, char direction) {
        this.position = position;
        this.direction = direction;
        this.path = new Path();
    }

    public void moveForward() {
        //move forward based on direction
        if (direction == 'N') {
            position.y--;
        } else if (direction == 'E') {
            position.x++;
        } else if (direction == 'S') {
            position.y++;
        } else {  //W
            position.x--;
        }
        path.addStep("F");
    }

    //only changes the direction, does not move the explorer
    public void turnLeft() {
        //turn left
        if (direction == 'N') {
            direction = 'W';
        } else if (direction == 'W') {
            direction = 'S';
        } else if (direction == 'S') {
            direction = 'E';
        } else {  // E
            direction = 'N';
        }
        path.addStep("L");
    
    }

    //only changes the direction, does not move the explorer
    public void turnRight() {
        //turn right
        if (direction == 'N') {
            direction = 'E';
        } else if (direction == 'E') {
            direction = 'S';
        } else if (direction == 'S') {
            direction = 'W';
        } else {  // W
            direction = 'N';
        }
        path.addStep("R");
    }

    //getters
    public Point getPosition() {
        return position;
    }

    public char getDirection() {
        return direction;
    }

    public Path getPath() {
        return path;
    }
}
