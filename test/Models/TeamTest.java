package Models;
/**
 * Created by zalmangagerman on 10/24/17.
 */
import Controllers.PlayerTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import Config.*;

import java.util.List;

import static org.mockito.Mockito.*;

import static Config.BoardConstants.TeamColor.*;

public class TeamTest {
    @Test public void testTeamConstructor() throws Exception {
        BoardConstants.TeamColor expectedColor = BLUE;
        TeamI team = new Team(expectedColor);
        assertEquals(expectedColor, team.getColor());
        assertEquals(0, team.getTeamSize());
        assertEquals(0, team.getPlayers().size());
    }

    @Test public void testAddPlayer() throws Exception {
        BoardConstants.TeamColor expectedColor = BLUE;
        TeamI team = new Team(expectedColor);
        PlayerI expectedPlayer = PlayerTest.generatePlayer();
        team.addPlayer(expectedPlayer);
        List<PlayerI> playersList = team.getPlayers();
        assertEquals(1, playersList.size());
        PlayerI actualPlayer = playersList.get(0);
        assertEquals(expectedPlayer.getId(), actualPlayer.getId());
        assertEquals(expectedPlayer.getTeam(), actualPlayer.getTeam());
        assertEquals(expectedPlayer.getPlayerName(), actualPlayer.getPlayerName());
        assertEquals(expectedPlayer.getPlayerPosition(), actualPlayer.getPlayerPosition());
    }

    @Test public void testAddPlayerMockito() throws Exception {
        PlayerI mockPlayer = mock(PlayerI.class);
        int expectedId = 1234;
        String expectedPlayerName = "ValuedTeamMember";
        PositionI mockPosition = mock(PositionI.class);
        int expectedRow = 4;
        int expectedCol = 5;
        when(mockPosition.getRow()).thenReturn(expectedRow);
        when(mockPosition.getCol()).thenReturn(expectedCol);
        BoardConstants.TeamColor expectedColor = BLUE;

        when(mockPlayer.getId()).thenReturn(expectedId);
        when(mockPlayer.getPlayerName()).thenReturn(expectedPlayerName);
        when(mockPlayer.getPlayerPiece()).thenReturn(null);
        when(mockPlayer.getPlayerPosition()).thenReturn(mockPosition);
        when(mockPlayer.getTeam()).thenReturn(expectedColor);

        assertEquals(expectedId, mockPlayer.getId());
        assertEquals(expectedColor, mockPlayer.getTeam());
        assertEquals(expectedPlayerName, mockPlayer.getPlayerName());
        assertEquals(expectedCol, mockPlayer.getPlayerPosition().getCol());
        assertEquals(expectedRow, mockPlayer.getPlayerPosition().getRow());
        assertEquals(null, mockPlayer.getPlayerPiece());
    }
}
