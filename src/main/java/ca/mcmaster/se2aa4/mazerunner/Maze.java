package ca.mcmaster.se2aa4.mazerunner;

import java.io.*;
import java.awt.Point;
public class Maze {
    private char[][] maze;
    private Point entry;
    private Point exit;

    public void readMaze(String filePath) {
       try{
            //BufferedReader reader = new BufferedReader(new FileReader(filePath));
            entry = new Point(0, 0);
            exit = new Point(4, 4);

            System.out.println("Maze read successfully");
        } catch (Exception e) {
            System.out.println("Error reading maze");
       }
    }   

    public Point getEntry() {
        return entry;
    }

    public Point getExit() {
        return exit;
    }

}
