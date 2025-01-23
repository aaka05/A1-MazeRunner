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

            
            findEntryAndExit();

            System.out.println("Maze read successfully");
            System.out.println("Entry point found at: " + entry);
            System.out.println("Exit point found at: " + exit);

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

    private void findEntryAndExit() {
        int rows = maze.length; //gets the number of rows
        int cols = maze[0].length; //just gets the first row length
        
        //check left border for an entry point
        for (int i = 0; i < rows; i++) {
            //in the first column, check if there is a space
            if (maze[i][0] == ' ') {
                entry = new Point(0, i);
                break;
            }
        }

        //check right border for an exit point
        for (int i = 0; i < rows; i++) {
            //in the last column, check if there is a space
            if (maze[i][cols-1] == ' ') {
                exit = new Point(cols-1, i);
                break;
            }
        }

        //if there is no entry or exit point, throw an error
        if (entry == null || exit == null) {
            throw new IllegalStateException("Maze must have both an entry point on the left and an exit point on the right");
        }
    }
}
