package ca.mcmaster.se2aa4.mazerunner;

import java.io.*;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import ca.mcmaster.se2aa4.mazerunner.Tiles.Tile;

public class Maze {
    private Tile[][] mazeTiles;
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

            int height = lines.size();

            //make the maze grid
            mazeTiles = new Tile[height][maxWidth];
            
            //fill the maze
            for (int i = 0; i < height; i++) {
                String currentLine = lines.get(i);
                //if shorter than maxWidth, add spaces to the end
                if (currentLine.length() < maxWidth) {
                    currentLine += " ".repeat(maxWidth - currentLine.length());  //pad with spaces
                }
                for (int j = 0; j < maxWidth; j++) {
                    char symbol = currentLine.charAt(j);
                    mazeTiles[i][j] = TileFactory.createTile(symbol);
                }
            }
            
            findEntryAndExit(lines);

        } catch (IOException e) {
            throw new IllegalStateException("Couldn't read the maze: " + e.getMessage());
        }
    }

    public void printMaze() {
        try {
            for (Tile[] row : mazeTiles) {
                for (Tile cell : row) {
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

    private void findEntryAndExit(List<String> lines) {
        int rows = lines.size();
        int cols = lines.get(0).length();
        
        entry = null;
        exit = null;
      
        //for entry point (it's the left most col)
        for (int i = 0; i < rows; i++) {
            char symbol = lines.get(i).charAt(0);
            if (symbol == ' ' || symbol == 'E') {
                entry = new Point(1, i + 1);
                break;
            }
        }

        //for exit point (it's the right most col)
        for (int i = 0; i < rows; i++) {
            char symbol = lines.get(i).charAt(cols - 1);
            if (symbol == ' ' || symbol == 'X') {
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
        int row = position.y - 1;
        int col = position.x - 1;
        return mazeTiles[row][col].isPassable();
    }

    //get the height of the maze
    public int getHeight() {
        return mazeTiles.length;
    }

    //get the width of the maze
    public int getWidth() {
        return mazeTiles[0].length;
    }
}
