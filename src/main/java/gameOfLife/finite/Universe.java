package gameOfLife.finite;

/**
 * Created by hamishdickson on 17/01/15.
 */
public class Universe {
    private boolean[][] grid;
    
    public Universe(int xCoord, int yCoord) {
        this.grid = new boolean[xCoord][yCoord];
    }

    public Universe(boolean[][] grid) {
        this.grid = grid;
    }

    public Universe iterate() {
        Universe newUniverse = new Universe(this.grid);
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[i].length; j++) {
                if (this.countNeighbours(i, j) == 2 || this.countNeighbours(i, j) == 3) newUniverse.setAlive(i, j);
            }
        }
        return newUniverse;
    }

    private int countNeighbours(int x, int y) {
        return 2;
    }

    public boolean isCellAlive(int xCoord, int yCoord) {
        return grid[xCoord][yCoord];
    }

    public void setAlive(int xCoord, int yCoord) {
        this.grid[xCoord][yCoord] = true;
    }
}
