package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.*;  
import org.junit.jupiter.api.Test;


public class PathTest {
    @Test
    public void testPathStoresSteps() {
        Path path = new Path();
        path.addStep("F");
        path.addStep("L");
        path.addStep("R");
        assertEquals(path.getPath().size(), 3);
        assertEquals(path.getPath().get(0), "F");
        assertEquals(path.getPath().get(1), "L");
        assertEquals(path.getPath().get(2), "R");
    }

    @Test
    public void testFactorizedPath() {
        Path path = new Path();
        path.addStep("F");
        path.addStep("F");
        path.addStep("R");
        path.addStep("R");
        path.addStep("F");
        path.addStep("F");
        path.addStep("L");
        path.addStep("L");
        path.addStep("F");
        path.addStep("F");
        assertEquals("2F 2R 2F 2L 2F", path.getFactorizedPath());
    }
    
    
}
