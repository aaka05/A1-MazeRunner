package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;      

import org.junit.jupiter.api.Test;

public class ExplorerTest {

    @Test
    public void testMoveForward() {
        Explorer explorer = new Explorer(new Point(2, 2), 'E');
        explorer.moveForward();
        assertEquals(explorer.getPosition(), new Point(3, 2));
    }

    @Test
    public void testTurnLeftChangesDirection() { 
        Explorer explorer = new Explorer(new Point(2, 2), 'E');
        explorer.turnLeft();
        assertEquals(explorer.getDirection(), 'N');
    }

    @Test
    public void testTurnRightChangesDirection() {
        Explorer explorer = new Explorer(new Point(2, 2), 'E');
        explorer.turnRight();
        assertEquals(explorer.getDirection(), 'S');
    }

        
}