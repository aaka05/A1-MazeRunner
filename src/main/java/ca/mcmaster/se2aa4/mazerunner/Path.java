package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

public class Path {
    private List<String> path;

    public Path() {
        this.path = new ArrayList<>();
    }
    
    public void addStep(String step) {
        path.add(step);
    }

    public List<String> getPath() {
        return path;
    }
}
