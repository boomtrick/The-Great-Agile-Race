package Controllers;
/**
 * Created by zalmangagerman on 10/24/17.
 */
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class TileControllerTest {
    @Test public void testMinimalConstructor() {
        int expectedRow;
        int expectedCol;
        boolean expectedEventExists;
        TileI actualTile;

        expectedRow = 3;
        expectedCol = 8;
        expectedEventExists = true;
        actualTile = new TileController(expectedRow, expectedCol, expectedEventExists);
        assertEquals(expectedRow, actualTile.getRow());
        assertEquals(expectedCol, actualTile.getCol());
        assertEquals(expectedEventExists, actualTile.hasEvent());


        expectedRow = 7;
        expectedCol = 2;
        expectedEventExists = false;
        actualTile = new TileController(expectedRow, expectedCol, expectedEventExists);
        assertEquals(expectedRow, actualTile.getRow());
        assertEquals(expectedCol, actualTile.getCol());
        assertEquals(expectedEventExists, actualTile.hasEvent());
    }

    @Test public void testDeletePlayer() throws Exception {
        //delete player
        //make sure that deleting the same player throws an exception
    }


}
