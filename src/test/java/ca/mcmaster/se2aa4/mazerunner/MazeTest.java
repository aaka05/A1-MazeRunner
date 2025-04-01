package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import java.awt.Point;
import static org.junit.jupiter.api.Assertions.*;

public class MazeTest {
    
    @Test
    public void testMazeEntryExitReading() {
        Maze maze = new Maze("examples/medium.maz.txt");
        Point entry = maze.getEntry();
        Point exit = maze.getExit();
        assertNotNull(entry);
        assertNotNull(exit);
        assertNotEquals(entry, exit);
    }

    @Test
    public void testIsPassage() {
        Maze maze = new Maze("examples/medium.maz.txt");
        Point entry = maze.getEntry();
        assertTrue(maze.isPassage(entry));
    }
}