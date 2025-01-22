package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");
        
        // Create command line options
        Options options = new Options();
        options.addOption("i", true, "Input file path");

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);
            
            if (!cmd.hasOption("i")) {
                logger.error("Missing required option: -i");
                System.exit(1);
            }

            String inputFile = cmd.getOptionValue("i");
            logger.info("**** Reading the maze from file {}", inputFile);

            Maze maze = new Maze(inputFile);
            logger.info("**** Maze read successfully");
            maze.printMaze();

        } catch(Exception e) {
            logger.error("An error has occurred", e);
        }
        logger.info("** End of MazeRunner");
    }
}
