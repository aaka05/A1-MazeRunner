package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.*;
  
import org.junit.jupiter.api.Test;


public class CheckPathTest {
    @Test
    public void testCheckValidPath() {
        Maze maze = new Maze("examples/small.maz.txt");
        PathFinder finder = new PathFinder(maze);
        Path solution = finder.solve();
        CheckPath checker = new CheckPath(maze);

        //expand the factorized path
        String rawPath = String.join("", solution.getPath());
        assertTrue(checker.checkPath(rawPath));
    }


    @Test
    public void testCheckInvalidPath() {
        Maze maze = new Maze("examples/small.maz.txt");
        CheckPath checker = new CheckPath(maze);
        assertFalse(checker.checkPath("FFFFF"));  // Path that hits a wall
    }

}
