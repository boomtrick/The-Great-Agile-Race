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

    @Test public void testConstructor() throws Exception {
        String expectedName = "ZalmanGagerman";
        Image expectedPiece = null;
        int expectedId = 124531;
        TeamColor expectedTeam = BLUE;
        PositionI expectedPosition = Player.startingPosition();
        PlayerI actualPlayer = new Player(expectedName, expectedPiece, expectedId,
                expectedTeam);
        assertEquals(expectedId, actualPlayer.getId());
        assertEquals(expectedTeam, actualPlayer.getTeam());
        assertEquals(expectedPiece, actualPlayer.getPlayerPiece());
        assertEquals(expectedId, actualPlayer.getPlayerID());
        assertEquals(expectedPosition, actualPlayer.getPlayerPosition());

    }

    @Test public void testMove() throws Exception {

    }

    @Test public void setPlayerPosition() throws Exception {

    }
}
