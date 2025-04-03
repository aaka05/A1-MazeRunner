package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.Tiles.OpenTile;
import ca.mcmaster.se2aa4.mazerunner.Tiles.Tile;
import ca.mcmaster.se2aa4.mazerunner.Tiles.WallTile;

public class TileFactory {
    public static Tile createTile(char symbol){
        if(symbol == '#'){
            return new WallTile();
        } else{
            return new OpenTile();
        }
    }
}
