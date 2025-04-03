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

    @Test
    public void testMazeOutOfBounds() {
        Maze maze = new Maze("examples/small.maz.txt");
        Point outOfBounds = new Point(100, 100);
        assertFalse(maze.isPassage(outOfBounds));
    }

    @Test
    public void testMazeDimensions() {
        Maze maze = new Maze("examples/small.maz.txt");
        assertTrue(maze.getHeight() > 0);
        assertTrue(maze.getWidth() > 0);
    }

    @Test
    public void testInvalidMazeFile() {
        assertThrows(IllegalStateException.class, () -> {
            new Maze("nonexistent.maz.txt");
        });
    }
}