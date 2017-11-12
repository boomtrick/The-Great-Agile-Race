package Models;
/**
 * Created by zalmangagerman on 10/24/17.
 */
import Controllers.PlayerTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import Config.*;

import java.util.List;

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
}
