package gameOfLife.finite;

/**
 * Created by hamishdickson on 17/01/15.
 */
public class CellPosition {
    private int xCoord;
    private int yCoord;

    public CellPosition(int xCoord, int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }
    
    public boolean isCellInUniverse(Universe universe) {
        return  (xCoord >= 0 && yCoord >= 0 && xCoord <= universe.WIDTH - 1 && yCoord <= universe.HEIGHT - 1);
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }
}
