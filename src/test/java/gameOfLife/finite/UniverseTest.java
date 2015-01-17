package gameOfLife.finite;

import junit.framework.TestCase;
import org.junit.Test;

public class UniverseTest extends TestCase {
    @Test
    public void testThatEmptyCellInEmptyUniverseStaysEmpty() {
        Universe universe = new Universe(5, 5);
        
        Universe nextUniverse = universe.iterate();
        
        assertEquals(false, nextUniverse.isCellAlive(1, 1));
    }
    
    @Test
    public void testAliveCellIsAlive() {
        Universe universe = new Universe(5, 5);
        
        universe.setAlive(1, 1);
        
        assertEquals(true, universe.isCellAlive(1, 1));
    }
    
    @Test
    public void testCellWithTwoNeighboursLivesInNextIteration() {
        Universe universe = new Universe(5, 5);
        universe.setAlive(0, 0);
        universe.setAlive(0, 1);
        
        universe.iterate();
        
        assertEquals(true, universe.isCellAlive(1, 0));
    }
}