package ca.mcmaster.se2aa4.mazerunner;

import java.io.*;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Maze {
    private char[][] maze;
    private Point entry;
    private Point exit;

    //constructor
    public Maze(String inputFile) {
        readMaze(inputFile);
    }

    //reads the maze from the input file
    public void readMaze(String inputFile) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            List<String> lines = new ArrayList<>();
            String line;
            int maxWidth = 0;
        
            //read all lines and find the maximum width of the maze
            while ((line = reader.readLine()) != null) {
                //convert empty lines to spaces 
                if (line.trim().isEmpty()) {
                    if (maxWidth > 0) {
                        //create a line of spaces with the same width as other lines
                        line = " ".repeat(maxWidth);
                    }
                }
                maxWidth = Math.max(maxWidth, line.length());
                lines.add(line);
            }
            reader.close();
            
            if (lines.isEmpty()) {
                throw new IllegalStateException("The maze file is empty");
            }
            
            //create the maze grid
            int rows = lines.size();
            maze = new char[rows][maxWidth];
            
            //fill the maze
            for (int i = 0; i < rows; i++) {
                String currentLine = lines.get(i);
                //if shorter than maxWidth, add spaces to the end
                if (currentLine.length() < maxWidth) {
                    currentLine = String.format("%-" + maxWidth + "s", currentLine);
                }
                maze[i] = currentLine.toCharArray();
            }
            
            findEntryAndExit();
            
            System.out.println("Maze read successfully");
            System.out.println("Entry point found at: " + entry);
            System.out.println("Exit point found at: " + exit);

        } catch (IOException e) {
            System.out.println("Error reading maze: " + e.getMessage());
            throw new IllegalStateException("Failed to read maze file", e);
        }
    }

    public void printMaze() {
        try {
            for (char[] row : maze) {
                for (char cell : row) {
                    System.out.print(cell);
                }
                System.out.println();
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
        int rows = maze.length;
        int cols = maze[0].length;
        
        entry = null;
        exit = null;
      
        //for entry point (it's the left most col)
        for (int i = 0; i < rows; i++) {
            if (maze[i][0] == ' ' || maze[i][0] == 'E') {
                entry = new Point(1, i + 1);
                break;
            }
        }

        //for exit point (it's the right most col)
        for (int i = 0; i < rows; i++) {
            if (maze[i][cols-1] == ' ' || maze[i][cols-1] == 'X') {
                exit = new Point(cols, i + 1);
                break;
            }
        }
        
        //if entry or exit not found, throw appropriate error
        if (entry == null || exit == null) {
            throw new IllegalStateException("Could not find valid entry and exit points in maze");
        }
    }

    //check if the point is PASS
    public boolean isPassage(Point position) {
        return maze[position.y - 1][position.x - 1] == ' ';
    }

    //get the height of the maze
    public int getHeight() {
        return maze.length;
    }

    //get the width of the maze
    public int getWidth() {
        return maze[0].length;
    }
}
