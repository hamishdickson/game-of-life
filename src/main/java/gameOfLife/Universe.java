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

    public void step() {
    }

    public void addAliveCell(Cell aliveCell) {
        cells.add(aliveCell);
    }
}
