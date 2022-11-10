package design;

import entities.DesignableMaze;
import entities.Maze;

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
    /* just a test
    public static void main(String[] args) {
        DesignableMaze bruh = new DesignableMaze(9, 35);
        MazeDesigner md = new MazeDesigner();
        md.resetMaze(bruh);
        for (int i = 0; i < bruh.getNumRow(); i++) {
            for (int j = 0; j < bruh.getNumCol(); j++) {
                if ((j)%(i+1) == 0 || (j)%(i+3) == 0){
                    md.buildWall(bruh,i,j);
                }
            }
        }
        md.removeWall(bruh, 2, 25);

        md.startPoint(bruh, 0, 25);
        md.endPoint(bruh, 8, 1);
        System.out.println(bruh);

        md.resetMaze(bruh);
        System.out.println(bruh);
    }
    */
}
