package gameOfLife.finite;

/**
 * Created by hamishdickson on 17/01/15.
 */
public class Universe {
    private boolean[][] grid;
    private final int WIDTH;
    private final int HEIGHT;
    
    public Universe(int xCoord, int yCoord) {
        this.grid = new boolean[xCoord][yCoord];
        this.WIDTH = xCoord;
        this.HEIGHT = yCoord;
    }

    public Universe(boolean[][] grid) {
        this.grid = grid;
        this.WIDTH = grid.length;
        this.HEIGHT = grid[0].length;
    }

    public Universe iterate() {
        Universe newUniverse = new Universe(this.WIDTH, this.HEIGHT);
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                int numberOfNeighbours = this.countNeighbours(j, i);
                if (numberOfNeighbours == 2 || numberOfNeighbours == 3) newUniverse.setAlive(j, i);
            }
        }
        return newUniverse;
    }

    private int countNeighbours(int x, int y) {
        int count = 0;
        if (x > 0 && y > 0 && isCellAlive(x-1, y-1)) {
            count++; // top left
        } else {
            // leave as is
        }
        
        if (y > 0 && this.isCellAlive(x, y-1)) count++; // top
        if (x < WIDTH - 1 && y > 0 && this.isCellAlive(x+1, y-1)) count++; // top right
        if (x > 0 && this.isCellAlive(x-1, y)) count++; // left
        if (x < WIDTH - 1 && this.isCellAlive(x+1, y)) count++; // right
        if (x > 0 && y < HEIGHT - 1 && this.isCellAlive(x-1, y+1)) count++; // bottom left
        if (y < HEIGHT - 1 && this.isCellAlive(x, y+1)) count++; // bottom
        if (x < WIDTH - 1 && y < HEIGHT - 1 && this.isCellAlive(x+1, y+1)) count++; // bottom right
        return count;
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
        
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (isCellAlive(j, i)) {
                    sb.append(ALIVE_CELL);
                } else {
                    sb.append(DEAD_CELL);
                }
                
                if (j == HEIGHT - 1) sb.append("\n");
            }
        }
        
        return sb.toString();
    }
}
