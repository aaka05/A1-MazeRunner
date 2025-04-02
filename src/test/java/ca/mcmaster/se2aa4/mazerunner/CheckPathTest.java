package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.*;
  
import org.junit.jupiter.api.Test;


public class CheckPathTest {
        @Test
        public void testCheckValidPath() {
            Maze maze = new Maze("examples/straight.maz.txt");
            String solution = "F F F F";
            CheckPath checker = new CheckPath(maze);
            assertTrue(checker.checkPath(solution));
        }


    @Test
    public void testCheckInvalidPath() {
        Maze maze = new Maze("examples/small.maz.txt");
        CheckPath checker = new CheckPath(maze);
        assertFalse(checker.checkPath("F F F F F"));  
    }

    @Test
    public void testCheckOutOfBoundsPath() {
        Maze maze = new Maze("examples/small.maz.txt");
        CheckPath checker = new CheckPath(maze);
        assertFalse(checker.checkPath("LLFF"));  
    }

    @Test
    public void testCheckWallCollision() {
        Maze maze = new Maze("examples/small.maz.txt");
        CheckPath checker = new CheckPath(maze);
        assertFalse(checker.checkPath("LF"));  
    }

}
