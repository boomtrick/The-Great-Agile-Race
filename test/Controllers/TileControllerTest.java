package Controllers;
/**
 * Created by zalmangagerman on 10/24/17.
 */
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class TileControllerTest {
    @Test public void testMinimalConstructor() {
        int expectedRow = 3;
        int expectedCol = 8;
        boolean expectedEventExists = true;
        TileI actualTile = new TileController(expectedRow, expectedCol, expectedEventExists);
        assertEquals(expectedRow, actualTile.getRow());
        assertEquals(expectedCol, actualTile.getCol());
        assertEquals(expectedEventExists, actualTile.hasEvent());
    }
}
