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

    @Test
    public void testMultipleDirectionChanges() {
        Explorer explorer = new Explorer(new Point(2, 2), 'N');
        explorer.turnRight();
        explorer.turnRight();
        explorer.turnRight();
        assertEquals(explorer.getDirection(), 'W');
    }

    @Test
    public void testMoveForwardInDifferentDirections() {
        Explorer explorer = new Explorer(new Point(2, 2), 'N');
        explorer.moveForward();
        assertEquals(explorer.getPosition(), new Point(2, 1));

        explorer.turnRight();
        explorer.moveForward();
        assertEquals(explorer.getPosition(), new Point(3, 1));
    }

    @Test
    public void testFullRotation() {
        Explorer explorer = new Explorer(new Point(2, 2), 'N');
        explorer.turnRight();
        assertEquals('E', explorer.getDirection());
        explorer.turnRight();
        assertEquals('S', explorer.getDirection());
        explorer.turnRight();
        assertEquals('W', explorer.getDirection());
        explorer.turnRight();
        assertEquals('N', explorer.getDirection());
    }

    @Test
    public void testPathRecording() {
        Explorer explorer = new Explorer(new Point(2, 2), 'N');
        explorer.moveForward();
        explorer.turnRight();
        explorer.moveForward();
        Path path = explorer.getPath();
        assertEquals("F R F", path.getFactorizedPath());
    }

    @Test
    public void testInitialState() {
        Point startPoint = new Point(1, 1);
        Explorer explorer = new Explorer(startPoint, 'N');
        assertEquals(startPoint, explorer.getPosition());
        assertEquals('N', explorer.getDirection());
    }
}