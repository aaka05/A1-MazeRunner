package ca.mcmaster.se2aa4.mazerunner;

import java.awt.Point;

public class Explorer {
    private Point position;
    private char direction;
    
    public Explorer(Point position, char direction) {
        this.position = position;
        this.direction = direction;
    }

    public void moveForward() {
        // Move forward
    }

    public void turnLeft() {
        // Turn left
    }

    public void turnRight() {
        // Turn right
    }

    public Point getPosition() {
        return position;
    }
  }
