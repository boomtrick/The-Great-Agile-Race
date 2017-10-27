package Controllers;
/**
 * Created by zalmangagerman on 10/24/17.
 */
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;
import java.util.UUID;
import java.util.Random;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import Config.BoardConstants.TeamColor;
import static Config.BoardConstants.TeamColor.*;

public class PlayerTest {
    private String expectedName_;
    private Image expectedPiece_;
    private int expectedId_;
    private TeamColor expectedTeam_;
    private PositionI expectedPosition_;
    private PlayerI actualPlayer_;

    @AfterEach public void tearDown() throws Exception {
        expectedName_ = null;
        expectedPiece_ = null;
        expectedId_ = -1;
        expectedTeam_ = null;
        expectedPosition_ = null;
        actualPlayer_ = null;
    }

    @Test public void testConstructor() throws Exception {
        expectedName_ = "ZalmanGagerman";
        expectedPiece_ = generateImage();
        expectedId_ = 124531;
        expectedTeam_ = BLUE;
        expectedPosition_ = Player.startingPosition();
        assertEquals(expectedId_, actualPlayer_.getId());
        assertEquals(expectedTeam_, actualPlayer_.getTeam());
        assertEquals(expectedPiece_, actualPlayer_.getPlayerPiece());
        assertEquals(expectedName_, actualPlayer_.getPlayerName());
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
        Image expectedPiece = generateImage();
        int expectedId = 124531;
        TeamColor expectedTeam = BLUE;
        PositionI expectedPosition = Player.startingPosition();
        return new Player(expectedName, expectedPiece, expectedId,
                expectedTeam);
    }

    public static PlayerI generateRandomPlayer(TeamColor team) throws Exception {
        String expectedName = UUID.randomUUID().toString();
        Image expectedPiece = generateImage();
        int expectedId = new Random(1000000).nextInt() + 1;
        //todo what to do about position????
        throw new NotImplementedException();
    }

    public static Image generateImage() {
        return null; //todo
    }


}
