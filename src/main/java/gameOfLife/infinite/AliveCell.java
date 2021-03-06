package gameOfLife.infinite;

/**
 * Created by hamishdickson on 13/01/15.
 */
public class AliveCell implements Cell {
    CellPosition cellPosition;
    
    public AliveCell(CellPosition cellPosition) {
        this.cellPosition = cellPosition;
    }

    @Override
    public boolean isAlive() {
        return true;
    }

    @Override
    public CellPosition getCellPosition() {
        return cellPosition;
    }

    @Override
    public boolean isAliveInNextStep() {
        int neighbours = this.countAliveNeighbours();
        return neighbours == 2 || neighbours == 3;
    }

    @Override
    public int countAliveNeighbours() {
        return 0;
    }
}
