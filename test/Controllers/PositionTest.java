package Controllers;
/**
 * Created by zalmangagerman on 10/24/17.
 */

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import static Config.BoardConstants.INITIAL_COLUMN;
import static Config.BoardConstants.INITIAL_ROW;

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
        actualPosition.setRow(expectedCol);
        assertEquals(expectedCol, actualPosition.getCol());
    }

    @Test public void testSetPosition() throws Exception {
        PositionI actualPosition = new Position();
        int expectedRow = 5;
        int expectedCol = 6;
        actualPosition.setPosition(expectedRow, expectedCol);
        assertEquals(expectedRow, actualPosition.getRow());

    }
}
