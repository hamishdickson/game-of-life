package gameOfLife.finite;

import junit.framework.TestCase;
import org.junit.Test;

public class CellPositionTest extends TestCase {
    @Test
    public void testThatIsOnEdgeMethodWorks() {
        Universe universe = new Universe(5, 5);
        
        CellPosition position00 = new CellPosition(0, 0);
        CellPosition position04 = new CellPosition(0, 4);
        CellPosition position40 = new CellPosition(4, 0);
        CellPosition position44 = new CellPosition(4, 4);

        CellPosition position11 = new CellPosition(1, 1);
        CellPosition position32 = new CellPosition(3, 2);
        
        CellPosition positionNeg10 = new CellPosition(-1, 0);
        CellPosition position0Neg1 = new CellPosition(0, -1);
        CellPosition positionNeg1Neg1 = new CellPosition(-1, -1);
        CellPosition position60 = new CellPosition(6, 0);
        CellPosition position06 = new CellPosition(0, 6);
        CellPosition position66 = new CellPosition(6, 6);

        assertEquals(true, position00.isCellInUniverse(universe));
        assertEquals(true, position04.isCellInUniverse(universe));
        assertEquals(true, position40.isCellInUniverse(universe));
        assertEquals(true, position44.isCellInUniverse(universe));
        assertEquals(true, position11.isCellInUniverse(universe));
        assertEquals(true, position32.isCellInUniverse(universe));


        assertEquals(false, positionNeg10.isCellInUniverse(universe));
        assertEquals(false, position0Neg1.isCellInUniverse(universe));
        assertEquals(false, positionNeg1Neg1.isCellInUniverse(universe));
        assertEquals(false, position60.isCellInUniverse(universe));
        assertEquals(false, position06.isCellInUniverse(universe));
        assertEquals(false, position66.isCellInUniverse(universe));
    }
}