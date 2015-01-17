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
    

}