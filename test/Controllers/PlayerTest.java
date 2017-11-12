package Controllers;
/**
 * Created by zalmangagerman on 10/24/17.
 */
import org.junit.jupiter.api.*;

import static Config.BoardConstants.BLUE_PIECE_FILE;
import static Config.BoardConstants.IMAGE_ENDING;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.UUID;
import java.util.Random;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import Config.BoardConstants.TeamColor;
import Models.Player;
import Models.PlayerI;
import Models.Position;
import Models.PositionI;

import javax.imageio.ImageIO;

import static Config.BoardConstants.TeamColor.*;

public class PlayerTest {
    private String expectedName_;
    private BufferedImage expectedPiece_;
    private int expectedId_;
    private TeamColor expectedTeam_;
    private PositionI expectedPosition_;
    private PlayerI actualPlayer_;
    private int teamMemberNum_;

    @AfterEach
    public void tearDown() throws Exception {
        expectedName_ = null;
        expectedPiece_ = null;
        expectedId_ = -1;
        expectedTeam_ = null;
        expectedPosition_ = null;
        actualPlayer_ = null;
        teamMemberNum_ = -1;
    }

    @Test
    public void testConstructor() throws Exception {
        expectedName_ = "ZalmanGagerman";
        expectedId_ = 124531;
        expectedTeam_ = BLUE;
        teamMemberNum_ = 1;
        expectedPiece_ = ImageIO.read(new File(BLUE_PIECE_FILE + teamMemberNum_ + IMAGE_ENDING));
        expectedPosition_ = Player.startingPosition();
        actualPlayer_ = new Player(expectedName_,
                expectedId_, expectedTeam_, teamMemberNum_);
        assertEquals(expectedId_, actualPlayer_.getId());
        assertEquals(expectedTeam_, actualPlayer_.getTeam());
        assertEquals(expectedName_, actualPlayer_.getPlayerName());
        assertEquals(expectedPosition_, actualPlayer_.getPlayerPosition());
    }

    @Test
    public void testMove() throws Exception {
        createActualPlayer();
        int expectedRow = 5;
        int expectedCol = 2;
        expectedPosition_ = new Position(expectedRow, expectedCol);
        actualPlayer_.move(expectedRow, expectedCol);
        assertEquals(expectedPosition_, actualPlayer_.getPlayerPosition());
    }

    @Test
    public void setPlayerPosition() throws Exception {
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
        teamMemberNum_ = 1;
        actualPlayer_ = new Player(expectedName_, expectedId_,
                expectedTeam_, teamMemberNum_);
        return actualPlayer_;
    }


    public static PlayerI generatePlayer() throws Exception {
        int teamMemberNum = 1;
        return generatePlayer(teamMemberNum);

    }

    public static PlayerI generatePlayer(int teamMemberNum) throws Exception {
        String expectedName = "ZalmanGagerman";
        int expectedId = 124531;
        TeamColor expectedTeam = BLUE;
        return new Player(expectedName, expectedId,
                expectedTeam, teamMemberNum);
    }

    public static PlayerI generateRandomPlayer(TeamColor team) throws Exception {
        String expectedName = UUID.randomUUID().toString();
        int expectedId = new Random(1000000).nextInt() + 1;
        //todo what to do about position????
        throw new NotImplementedException();
    }
}
