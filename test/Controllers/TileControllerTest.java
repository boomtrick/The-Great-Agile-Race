package Controllers;
/**
 * Created by zalmangagerman on 10/24/17.
 */
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class TileControllerTest {
    private int expectedRow_;
    private int expectedCol_;
    private boolean expectedEventExists_;
    private List<PlayerI> expectedPlayers_;
    private int expectedSize_;
    private TileI actualTile_;


    @AfterEach public void tearDown() throws Exception {
        expectedRow_ = -1;
        expectedCol_ = -1;
        expectedEventExists_ = false;
        expectedPlayers_ = null;
        expectedSize_ = -1;
    }

    @Test public void testMinimalConstructor() throws Exception {
        expectedRow_ = 3;
        expectedCol_ = 8;
        expectedEventExists_ = true;
        actualTile_ = new TileController(expectedRow_, expectedCol_, expectedEventExists_);
        testGetters();
        ////new test////
        expectedRow_ = 7;
        expectedCol_ = 2;
        expectedEventExists_ = false;
        actualTile_ = new TileController(expectedRow_, expectedCol_, expectedEventExists_);
        testGetters();
    }

    @Test public void testDeletePlayer() throws Exception {
        expectedRow_ = 7;
        expectedCol_ = 2;
        expectedEventExists_ = false;
        PlayerI expectedPlayer_ = PlayerTest.generatePlayer();
        expectedPlayers_ = new ArrayList<>();
        expectedPlayers_.add(expectedPlayer_);
        expectedSize_ = 1;
        actualTile_ = new TileController(expectedRow_, expectedCol_, expectedEventExists_);
        assertEquals(expectedSize_, actualTile_.getSize());
        actualTile_.deletePlayer(expectedPlayer_);
        expectedSize_ = 0;
        assertEquals(expectedSize_, actualTile_.getSize());
    }

    @Test public void testDeleteUnknownPlayer() throws Exception {
        fail("Not implemented");
        try {
            // todo fill in
            fail("Should have thrown IAE");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    public static TileI generateTile(boolean eventExists) throws Exception {
        int expectedRow = 3;
        int expectedCol = 2;
        int expectedSize_ = 0;
        return new TileController(expectedRow, expectedCol, eventExists);
    }

    public void testGetters() throws Exception {
        assertEquals(expectedRow_, actualTile_.getRow());
        assertEquals(expectedCol_, actualTile_.getCol());
        assertEquals(expectedEventExists_, actualTile_.hasEvent());
        assertEquals(expectedSize_, actualTile_.getSize());
    }
}
