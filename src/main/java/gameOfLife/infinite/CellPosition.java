package gameOfLife.infinite;

/**
 * Created by hamishdickson on 13/01/15.
 *
 */
public class CellPosition {
    private final int xCoord;
    private final int yCoord;

    public CellPosition(int xCoord, int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CellPosition that = (CellPosition) o;

        if (xCoord != that.xCoord) return false;
        if (yCoord != that.yCoord) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = xCoord;
        result = 31 * result + yCoord;
        return result;
    }
}
