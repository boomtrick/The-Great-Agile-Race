package Models;

import Config.BoardConstants.TeamColor;
import Controllers.PlayerI;

import java.util.List;

/**
 * Created by zalmangagerman on 10/24/17.
 */
public interface TeamI {
    TeamColor getColor();
    List<PlayerI> getPlayers();
    void setPlayers(List<PlayerI> players);
    void addPlayer(PlayerI player);
}
