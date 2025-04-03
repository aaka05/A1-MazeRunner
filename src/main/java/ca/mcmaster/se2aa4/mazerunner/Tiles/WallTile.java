package ca.mcmaster.se2aa4.mazerunner.Tiles;

public class WallTile extends Tile {
    @Override
    public boolean isPassable() {
        return false;
    }

    @Override
    public String toString() {
        return "#";
    }
}
