package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
            logger.info("**** Reading the maze from file {}", inputFile);

            //read the maze from the input file
            Maze maze = new Maze(inputFile);
            logger.info("**** Maze read successfully");

            //if the path to check is provided, verify the path
            if (cmd.hasOption("p")) {
                String pathToCheck = cmd.getOptionValue("p");
                CheckPath checker = new CheckPath(maze);
                System.out.println(checker.checkPath(pathToCheck) ? "Valid path" : "Invalid path");
            } else {
                //otherwise, solve the maze and display the path
                PathFinder solver = new PathFinder(maze);
                Path solution = solver.solve();
                System.out.println(solution.getFactorizedPath());
            }
            
        } catch(Exception e) {
            logger.error("An error has occurred", e);
        }
        logger.info("** End of MazeRunner");
    }
}
