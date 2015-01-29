package gameOfLife.infinite;

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
    public void testDeadCellWithNoNeighboursIsNotBorn() {
        Universe universe = new Universe();
        CellPosition cellPosition = new CellPosition(1, 1);

        Universe nextUniverse = universe.step();

        assertEquals(0, nextUniverse.numberOfAliveCells());
    }
    
    @Test
    public void testAliveCellWithTwoLiveNeighboursLives() {
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

    @Test
    public void testAliveCellWithThreeLiveNeighboursLives() {
        Universe universe = new Universe();
        CellPosition cellPosition1 = new CellPosition(1, 1);
        CellPosition cellPosition2 = new CellPosition(2, 1);
        CellPosition cellPosition3 = new CellPosition(3, 1);
        CellPosition testCellPosition = new CellPosition(2, 2);

        Cell otherCell1 = new AliveCell(cellPosition1);
        Cell otherCell2 = new AliveCell(cellPosition2);
        Cell otherCell3 = new AliveCell(cellPosition3);
        Cell testCell = new AliveCell(testCellPosition);

        universe.addAliveCell(otherCell1);
        universe.addAliveCell(otherCell2);
        universe.addAliveCell(otherCell3);
        universe.addAliveCell(testCell);

        Universe universe1 = universe.step();

        assertEquals(true, universe1.cellIsAliveAtPosition(testCellPosition));
    }

    @Test
    public void testAliveCellWithFourLiveNeighboursDies() {
        Universe universe = new Universe();
        CellPosition cellPosition1 = new CellPosition(1, 1);
        CellPosition cellPosition2 = new CellPosition(2, 1);
        CellPosition cellPosition3 = new CellPosition(3, 1);
        CellPosition cellPosition4 = new CellPosition(1, 2);
        CellPosition testCellPosition = new CellPosition(2, 2);

        Cell otherCell1 = new AliveCell(cellPosition1);
        Cell otherCell2 = new AliveCell(cellPosition2);
        Cell otherCell3 = new AliveCell(cellPosition3);
        Cell otherCell4 = new AliveCell(cellPosition4);
        Cell testCell = new AliveCell(testCellPosition);

        universe.addAliveCell(otherCell1);
        universe.addAliveCell(otherCell2);
        universe.addAliveCell(otherCell3);
        universe.addAliveCell(otherCell4);
        universe.addAliveCell(testCell);

        Universe universe1 = universe.step();

        assertEquals(false, universe1.cellIsAliveAtPosition(testCellPosition));
    }

    @Test
    public void testDeadCellWithTwoLiveNeighboursIsNotBorn() {
        Universe universe = new Universe();
        CellPosition cellPosition1 = new CellPosition(1, 1);
        CellPosition cellPosition2 = new CellPosition(2, 1);
        CellPosition deadCellPosition = new CellPosition(1, 2);

        Cell otherCell1 = new AliveCell(cellPosition1);
        Cell otherCell2 = new AliveCell(cellPosition2);

        universe.addAliveCell(otherCell1);
        universe.addAliveCell(otherCell2);

        Universe universe1 = universe.step();

        assertEquals(false, universe1.cellIsAliveAtPosition(deadCellPosition));
    }

    @Test
    public void testDeadCellWithThreeLiveNeighboursIsBorn() {
        Universe universe = new Universe();
        CellPosition cellPosition1 = new CellPosition(1, 1);
        CellPosition cellPosition2 = new CellPosition(2, 1);
        CellPosition cellPosition3 = new CellPosition(2, 1);
        CellPosition deadCellPosition = new CellPosition(1, 2);

        Cell otherCell1 = new AliveCell(cellPosition1);
        Cell otherCell2 = new AliveCell(cellPosition2);
        Cell otherCell3 = new AliveCell(cellPosition3);

        universe.addAliveCell(otherCell1);
        universe.addAliveCell(otherCell2);
        universe.addAliveCell(otherCell3);

        Universe universe1 = universe.step();

        assertEquals(true, universe1.cellIsAliveAtPosition(deadCellPosition));
    }

    @Test
    public void testCellWithOneLiveNeighboursDies() {
        Universe universe = new Universe();
        CellPosition cellPosition1 = new CellPosition(1, 1);
        CellPosition cellPosition2 = new CellPosition(2, 1);

        Cell otherCell1 = new AliveCell(cellPosition1);
        Cell testCell = new AliveCell(cellPosition2);

        universe.addAliveCell(otherCell1);
        universe.addAliveCell(testCell);

        Universe universe1 = universe.step();

        assertEquals(false, universe1.cellIsAliveAtPosition(cellPosition2));
    }
}