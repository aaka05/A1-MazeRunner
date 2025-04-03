package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.mcmaster.se2aa4.mazerunner.Tools.MazeTool;

import org.apache.commons.cli.*;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");
        
        Options options = new Options();
        options.addOption("i", true, "Input file path");
        options.addOption("p", true, "Path to check");

        try {
            CommandLine cmd = new DefaultParser().parse(options, args);

            //if the input file is not provided, throw an error
            if (!cmd.hasOption("i")) {
                logger.error("Missing required option: -i");
                System.exit(1);
            }

            String inputFile = cmd.getOptionValue("i");
            String pathToCheck = cmd.getOptionValue("p");

            logger.info("**** Reading the maze from file {}", inputFile);

            //read the maze from the input file
            Maze maze = new Maze(inputFile);
            logger.info("**** Maze read successfully");

            //factory pattern to create the correct tool
            MazeTool tool = MazeToolFactory.createTool(maze, pathToCheck);
            tool.run();

        } catch(Exception e) {
            logger.error("An error has occurred", e);
        }
        logger.info("** End of MazeRunner");
    }
}
