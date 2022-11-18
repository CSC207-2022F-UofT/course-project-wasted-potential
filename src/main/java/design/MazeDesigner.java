package design;

import entities.DesignableMaze;

public class MazeDesigner {

    public void resetMaze(DesignableMaze dm){
        dm.emptySetup();
    }

    public void buildWall(DesignableMaze dm, int row, int col){
        if (dm.getState(row, col) != '#') {
            dm.placeWall(row, col);
        }
    }
    public void removeWall(DesignableMaze dm, int row, int col){
        if (row != 0 && col != 0 && row != dm.getNumRow()-1 && col != dm.getNumCol()-1) {
            if (dm.getState(row, col) != '.') {
                dm.deleteWall(row, col);
            }
        }
    }

    public void startPoint(DesignableMaze dm, int row, int col){
        if (dm.getState(row, col) != 'S') {
            dm.placeStart(row, col);
        }
    }

    public void endPoint(DesignableMaze dm, int row, int col){
        if (dm.getState(row, col) != 'E') {
            dm.placeEnd(row, col);
        }
    }

    public int getRows(DesignableMaze dm){
        return dm.getNumRow();
    }
    public int getCols(DesignableMaze dm){
        return dm.getNumCol();
    }
    public String cellString(DesignableMaze dm, int row, int col){
        return String.valueOf(dm.getState(row, col));
    }
    public char cellChar(DesignableMaze dm, int row, int col){
        return dm.getState(row, col);
    }

}
