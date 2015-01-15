package gameOfLife;

/**
 * Created by hamishdickson on 13/01/15.
 */
public interface Cell {
    public boolean isAlive();
    public CellPosition getCellPosition();

    boolean isAliveInNextStep();

    int countAliveNeighbours();
}
