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
}