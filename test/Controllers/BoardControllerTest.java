package Controllers;
/**
 * Created by zalmangagerman on 10/24/17.
 */
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class BoardControllerTest {
    private int expectedRows_;
    private int expectedCols_;
    private BoardI actualBoard_;

    @AfterEach public void tearDown() throws Exception {
        expectedRows_ = -1;
        expectedCols_ = -1;
        actualBoard_ = null;
    }

    @Test public void testPrimaryConstuctor() throws Exception {
        fail("Not implemented");
        assertEquals(expectedRows_, actualBoard_.getRowSize());
        assertEquals(expectedCols_, actualBoard_.getColSize());
    }

    private void createEmptyBoard() {
        actualBoard_ = generateEmptyBoard();
        throw new NotImplementedException();
    }


    @Test public void testDuplicatedId() throws Exception {
        fail("Not implemented");
    }


    public static BoardI generateEmptyBoard() {
        throw new NotImplementedException();
    }
}
