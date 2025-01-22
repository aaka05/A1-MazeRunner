package ca.mcmaster.se2aa4.mazerunner;

import java.io.*;
import java.awt.Point;
public class Maze {
    private char[][] maze;
    private Point entry;
    private Point exit;

    public Maze(String inputFile) {
        readMaze(inputFile);
    }

    public void readMaze(String inputFile) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line;
            StringBuilder mazeBuilder = new StringBuilder();
            int rows = 0;
            int cols = 0;

            
            while ((line = reader.readLine()) != null) {
                mazeBuilder.append(line).append("\n");
                rows++;
                cols = line.length();
            }

            
            maze = new char[rows][cols];
            String[] lines = mazeBuilder.toString().split("\n");

           
            for (int i = 0; i < rows; i++) {
                maze[i] = lines[i].toCharArray();
            }

            System.out.println("Maze read successfully");
        } catch (Exception e) {
            System.out.println("Error reading maze: " + e.getMessage());
        }
    }

    public void printMaze() {
        try {
            for (char[] row : maze) {
                StringBuilder displayRow = new StringBuilder();
                for (char cell : row) {
                    if (cell == '#') {
                        displayRow.append("WALL ");
                    } else if (cell == ' ') {
                        displayRow.append("PASS ");
                    }
                }
                System.out.println(displayRow.toString());
            }
        } catch (Exception e) {
            System.out.println("Error displaying maze: " + e.getMessage());
        }
    }

    public Point getEntry() {
        return entry;
    }

    public Point getExit() {
        return exit;
    }
}
