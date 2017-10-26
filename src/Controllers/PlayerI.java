package Controllers;

/**
 * Created by zalmangagerman on 10/8/17.
 * 
 */
import Config.BoardConstants.TeamColor;

import java.awt.*;
public interface PlayerI {
    void move(int i, int j);
    int getId();
    TeamColor getTeam();
    String getPlayerName();
    Image getPlayerPiece();
    int getPlayerID();
    PositionI getPlayerPosition();
    void setPlayerPosition(PositionI playerPosition);
}
