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
    private TileI actualTile_;

    @AfterEach public void tearDown() throws Exception {
        expectedRow_ = -1;
        expectedCol_ = -1;
        expectedEventExists_ = false;
        expectedPlayers_ = null;
    }

    @Test public void testMinimalConstructor() {
        expectedRow_ = 3;
        expectedCol_ = 8;
        expectedEventExists_ = true;
        actualTile_ = new TileController(expectedRow_, expectedCol_, expectedEventExists_);
        assertEquals(expectedRow_, actualTile_.getRow());
        assertEquals(expectedCol_, actualTile_.getCol());
        assertEquals(expectedEventExists_, actualTile_.hasEvent());
        ////new test////
        expectedRow_ = 7;
        expectedCol_ = 2;
        expectedEventExists_ = false;
        actualTile_ = new TileController(expectedRow_, expectedCol_, expectedEventExists_);
        assertEquals(expectedRow_, actualTile_.getRow());
        assertEquals(expectedCol_, actualTile_.getCol());
        assertEquals(expectedEventExists_, actualTile_.hasEvent());
    }

    @Test public void testDeletePlayer() throws Exception {
        expectedRow_ = 7;
        expectedCol_ = 2;
        expectedEventExists_ = false;
        PlayerI expectedPlayer_ = new Player(yest)
        expectedPlayers_ = new ArrayList<>().add(something)
        actualTile_ = new TileController(expectedRow_, expectedCol_, expectedEventExists_);

    }


}
