package ca.mcmaster.se2aa4.mazerunner.Tiles;

public class OpenTile extends Tile {
    @Override
    public boolean isPassable() {
        return true;
    }

    @Override
    public String toString() {
        return " ";
    }
}
