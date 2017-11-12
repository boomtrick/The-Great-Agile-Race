package Controllers;
/**
 * Created by zalmangagerman on 10/24/17.
 */

import org.junit.jupiter.api.*;

import Models.Position;
import Models.PositionI;

import static Config.BoardConstants.*;
import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {

    @Test public void testEmptyConstructor() throws Exception {
        int expectedRow = INITIAL_ROW;
        int expectedColumn = INITIAL_COLUMN;
        PositionI actualPosition = new Position();
        assertEquals(expectedRow, actualPosition.getRow());
        assertEquals(expectedColumn, actualPosition.getCol());
    }

    @Test public void testMaxConstructor() throws Exception {
        int expectedRow = 3;
        int expectedCol = 2;
        PositionI actualPosition = new Position(3, 2);
        assertEquals(expectedRow, actualPosition.getRow());
        assertEquals(expectedCol, actualPosition.getCol());
    }

    @Test public void testSetRow() throws Exception {
        PositionI actualPosition = new Position();
        int expectedRow = 5;
        actualPosition.setRow(expectedRow);
        assertEquals(expectedRow, actualPosition.getRow());
    }

    @Test public void testSetCol() throws Exception {
        PositionI actualPosition = new Position();
        int expectedCol = 5;
        actualPosition.setCol(expectedCol);
        assertEquals(expectedCol, actualPosition.getCol());
    }

    @Test public void testSetPosition() throws Exception {
        PositionI actualPosition = new Position();
        int expectedRow = 5;
        int expectedCol = 6;
        actualPosition.setPosition(expectedRow, expectedCol);
        assertEquals(expectedRow, actualPosition.getRow());
    }

    @Test
    public void testSetPositionIllegalDouble() throws Exception {
        int expectedRow;
        int expectedCol;

        PositionI actualPosition = new Position();

        expectedRow = -5;
        expectedCol = 6;
        try {
            actualPosition.setPosition(expectedRow, expectedCol);
            fail("Should have thrown IAE");
        } catch (IllegalArgumentException iae) {
        }

        expectedRow = ROW_SIZE + 1;
        expectedCol = 6;
        try {
            actualPosition.setPosition(expectedRow, expectedCol);
            fail("Should have thrown IAE");
        } catch (IllegalArgumentException iae) {
        }

        expectedRow = 2;
        expectedCol = -10;
        try {
            actualPosition.setPosition(expectedRow, expectedCol);
        } catch (IllegalArgumentException iae) {
        }

        expectedRow = 2;
        expectedCol = COL_SIZE + 1;
        try {
            actualPosition.setPosition(expectedRow, expectedCol);
            fail("Should have thrown IAE");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    public void testSetRowIllegal() throws Exception {
        int expectedRow;
        PositionI actualPosition = new Position();

        expectedRow = -5;
        try {
            actualPosition.setRow(expectedRow);
            fail("Should have thrown IAE");
        } catch (IllegalArgumentException iae) {
        }

        expectedRow = ROW_SIZE + 1;
        try {
            actualPosition.setRow(expectedRow);
            fail("Should have thrown IAE");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    public void testSetColIllegal() throws Exception {
        int expectedCol;
        PositionI actualPosition = new Position();

        expectedCol = -5;
        try {
            actualPosition.setCol(expectedCol);
            fail("Should have thrown IAE");
        } catch (IllegalArgumentException iae) {
        }

        expectedCol = COL_SIZE + 1;
        try {
            actualPosition.setCol(expectedCol);
            fail("Should have thrown IAE");
        } catch (IllegalArgumentException iae) {
        }
    }


}
