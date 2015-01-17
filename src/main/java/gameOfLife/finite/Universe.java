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
        return new Universe(this.grid);
    }

    public boolean isCellAlive(int xCoord, int yCoord) {
        return grid[xCoord][yCoord];
    }

    public void setAlive(int xCoord, int yCoord) {
        this.grid[xCoord][yCoord] = true;
    }
}
