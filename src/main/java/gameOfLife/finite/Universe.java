package gameOfLife.finite;

/**
 * Created by hamishdickson on 17/01/15.
 */
public class Universe {
    private int[][] grid;
    
    public Universe(int width, int height) {
        this.grid = new int[width][height];
    }

    public Universe(int[][] grid) {
        this.grid = grid;
    }

    public Universe iterate() {
        return new Universe(this.grid);
    }

    public boolean isCellAlive(int height, int width) {
        return false;
    }
}
