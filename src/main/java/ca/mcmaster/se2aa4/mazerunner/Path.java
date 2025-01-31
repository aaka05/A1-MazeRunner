package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

public class Path {
    //no implementation as of now
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

    //gets the factorized path
    public String getFactorizedPath() {
        //no path
        if (path.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        String currentStep = path.get(0);
        int count = 1;

        //loop through the path from the second element
        for (int i = 1; i < path.size(); i++) {
            if (path.get(i).equals(currentStep)) {
                count++;
            } else {
                //add the count and step to result if count > 1
                if (count > 1) {
                    result.append(count);
                }
                result.append(currentStep).append(",");
                currentStep = path.get(i);
                count = 1;
            }
        }
        //for the last group of steps
        if (count > 1) {
            result.append(count);
        }
        result.append(currentStep);

        return result.toString();
    }

    //returns paths
    public String toString() {
        String normalPath = String.join("", path);
        String factorized = getFactorizedPath();
        return String.format("Path: %s%nFactorized: %s", normalPath, factorized);
    }
}
