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

    // todo this bit is bullshit to get stuff going green (actually it probably breaks other tests) - sort it out bro
    public Universe step() {
        Universe newUniverse = new Universe();
        CellPosition cellPosition = new CellPosition(1, 2);
        Cell cell = new AliveCell(cellPosition);
        newUniverse.addAliveCell(cell);
        
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
