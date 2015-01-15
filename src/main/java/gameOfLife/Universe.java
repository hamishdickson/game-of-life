package gameOfLife;

import java.util.ArrayList;

/**
 * Created by hamishdickson on 13/01/15.
 */
public class Universe {
    ArrayList<Cell> cells = new ArrayList<Cell>();

    public int numberOfAliveCells() {
        return cells.size();
    }

    public Universe step() {
        Universe newUniverse = new Universe();
        
        // todo only tests if current alive cells stay alive - that aint't right
        for (Cell cell : cells) {
            if (cell.isAliveInNextStep()) {
                newUniverse.addAliveCell(cell);
            }
        }

        return newUniverse;
    }

    public void addAliveCell(Cell aliveCell) {
        cells.add(aliveCell);
    }

    public boolean cellIsAliveAtPosition(CellPosition cellPosition) {
        
        for (Cell cell : cells) {
            if (cell.getCellPosition().equals(cellPosition)) return true;
        }
        
        return false;
    }
}
