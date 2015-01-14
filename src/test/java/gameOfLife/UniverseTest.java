package gameOfLife;

import junit.framework.TestCase;
import org.junit.Test;

public class UniverseTest extends TestCase {
    @Test
    public void testEmptyUniverseStaysEmpty() {
        Universe universe = new Universe();
        
        Universe universe1 = universe.step();
        
        assertEquals(0, universe1.numberOfAliveCells());
    }
    
    @Test
    public void testNumberOfAliveCellsDetectsOneAliveCell() {
        Universe universe = new Universe();
        
        CellPosition cellPosition = new CellPosition(1, 1);
        
        Cell aliveCell = new AliveCell(cellPosition);
        
        universe.addAliveCell(aliveCell);
        
        assertEquals(1, universe.numberOfAliveCells());
    }
    
    @Test
    public void testSingleCellDiesOnStep() {
        Universe universe = new Universe();
        CellPosition cellPosition = new CellPosition(1, 1);
        Cell aliveCell = new AliveCell(cellPosition);
        universe.addAliveCell(aliveCell);
        
        Universe nextUniverse = universe.step();
        
        assertEquals(0, nextUniverse.numberOfAliveCells());
    }
    
    @Test
    public void testCellWithTwoLiveNeighboursLives() {
        Universe universe = new Universe();
        CellPosition cellPosition1 = new CellPosition(1, 1);
        CellPosition cellPosition2 = new CellPosition(2, 1);
        CellPosition cellPosition3 = new CellPosition(1, 2);
        
        Cell otherCell1 = new AliveCell(cellPosition1);
        Cell otherCell2 = new AliveCell(cellPosition2);
        Cell testCell = new AliveCell(cellPosition3);
        
        universe.addAliveCell(otherCell1);
        universe.addAliveCell(otherCell2);
        universe.addAliveCell(testCell);
        
        Universe universe1 = universe.step();
        
        assertEquals(true, universe1.cellIsAliveAtPosition(cellPosition3));
    }
}