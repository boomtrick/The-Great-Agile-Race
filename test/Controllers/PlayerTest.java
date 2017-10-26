package Controllers;
/**
 * Created by zalmangagerman on 10/24/17.
 */
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;

import Config.BoardConstants.TeamColor;

import static Config.BoardConstants.TeamColor.*;

public class PlayerTest {
    String expectedName_;
    Image expectedPiece_;
    int expectedId_;
    TeamColor expectedTeam_;
    PositionI expectedPosition_;
    PlayerI actualPlayer_;

    @AfterEach public void tearDown() throws Exception {
        expectedName_ = null;
        expectedPiece_ = null;
        expectedId_ = -1;
        expectedTeam_ = null;
        expectedPosition_ = null;
        actualPlayer_ = null;
    }

    @Test public void testConstructor() throws Exception {
        createActualPlayer();
        assertEquals(expectedId_, actualPlayer_.getId());
        assertEquals(expectedTeam_, actualPlayer_.getTeam());
        assertEquals(expectedPiece_, actualPlayer_.getPlayerPiece());
        assertEquals(expectedId_, actualPlayer_.getPlayerID());
        assertEquals(expectedPosition_, actualPlayer_.getPlayerPosition());
    }

    @Test public void testMove() throws Exception {
        createActualPlayer();
        int expectedRow = 5;
        int expectedCol = 2;
        expectedPosition_ = new Position(expectedRow, expectedCol);
        actualPlayer_.move(expectedRow, expectedCol);
        assertEquals(expectedPosition_, actualPlayer_.getPlayerPosition());
    }

    @Test public void setPlayerPosition() throws Exception {
        createActualPlayer();
        int expectedRow = 5;
        int expectedCol = 2;
        expectedPosition_ = new Position(expectedRow, expectedCol);
        actualPlayer_.setPlayerPosition(expectedPosition_);
        assertEquals(expectedPosition_, actualPlayer_.getPlayerPosition());
    }

    private PlayerI createActualPlayer() throws Exception {
        actualPlayer_ = generatePlayer();
        expectedName_ = actualPlayer_.getPlayerName();
        expectedPiece_ = actualPlayer_.getPlayerPiece();
        expectedId_ = actualPlayer_.getId();
        expectedTeam_ = actualPlayer_.getTeam();
        expectedPosition_ = actualPlayer_.getPlayerPosition();
        actualPlayer_ = new Player(expectedName_, expectedPiece_, expectedId_,
                expectedTeam_);
        return actualPlayer_;
    }

    public static PlayerI generatePlayer() throws Exception {
        String expectedName = "ZalmanGagerman";
        Image expectedPiece = null;
        int expectedId = 124531;
        TeamColor expectedTeam = BLUE;
        PositionI expectedPosition = Player.startingPosition();
        return new Player(expectedName, expectedPiece, expectedId,
                expectedTeam);
    }
}
