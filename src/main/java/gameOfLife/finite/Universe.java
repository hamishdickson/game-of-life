package gameOfLife.finite;

/**
 * Created by hamishdickson on 17/01/15.
 */
public class Universe {
    private boolean[][] grid;
    private final int WIDTH;
    private final int HEIGHT;
    
    public Universe(int width, int height) {
        this.grid = new boolean[width][height];
        this.WIDTH = width;
        this.HEIGHT = height;
    }

    public Universe iterate() {
        Universe newUniverse = new Universe(this.WIDTH, this.HEIGHT);
        for (int j = 0; j < HEIGHT; j++) {
            for (int i = 0; i < WIDTH; i++) {
                int numberOfNeighbours = this.countNeighbours(i, j);
                if (numberOfNeighbours == 2 || numberOfNeighbours == 3) newUniverse.setAlive(i, j);
            }
        }
        return newUniverse;
    }

    private int countNeighbours(int x, int y) {
        int count = 0;
        if (isTopLeftCellAlive(x, y)) count++;
        if (isTopCellAlive(x, y)) count++;
        if (isTopRightCellAlive(x, y)) count++;
        if (isLeftCellAlive(x, y)) count++;
        if (isRightCellAlive(x, y)) count++;
        if (isBottomLeftCellAlive(x, y)) count++;
        if (isBottomCellAlive(x, y)) count++;
        if (isBottomRightCellAlive(x, y)) count++;
        return count;
    }

    private boolean isBottomRightCellAlive(int x, int y) {
        return x < WIDTH - 1 && y < HEIGHT - 1 && this.isCellAlive(x+1, y+1);
    }

    private boolean isBottomCellAlive(int x, int y) {
        return y < HEIGHT - 1 && this.isCellAlive(x, y+1);
    }

    private boolean isBottomLeftCellAlive(int x, int y) {
        return x > 0 && y < HEIGHT - 1 && this.isCellAlive(x-1, y+1);
    }

    private boolean isRightCellAlive(int x, int y) {
        return x < WIDTH - 1 && this.isCellAlive(x+1, y);
    }

    private boolean isLeftCellAlive(int x, int y) {
        return x > 0 && this.isCellAlive(x-1, y);
    }

    private boolean isTopRightCellAlive(int x, int y) {
        return x < WIDTH - 1 && y > 0 && this.isCellAlive(x+1, y-1);
    }

    private boolean isTopCellAlive(int x, int y) {
        return y > 0 && this.isCellAlive(x, y-1);
    }

    private boolean isTopLeftCellAlive(int x, int y) {
        return x > 0 && y > 0 && isCellAlive(x-1, y-1);
    }

    public boolean isCellAlive(int xCoord, int yCoord) {
        return grid[xCoord][yCoord];
    }

    public void setAlive(int xCoord, int yCoord) {
        this.grid[xCoord][yCoord] = true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        String DEAD_CELL = " ";
        String ALIVE_CELL = "+";
        
        for (int j = 0; j < HEIGHT; j++) {
            for (int i = 0; i < WIDTH; i++) {
                if (isCellAlive(i, j)) {
                    sb.append(ALIVE_CELL);
                } else {
                    sb.append(DEAD_CELL);
                }
                
                if (i == HEIGHT - 1) sb.append("\n");
            }
        }
        
        return sb.toString();
    }
}
