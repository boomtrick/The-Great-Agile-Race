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
    void setPlayerName(String playerName);
    Image getPlayerPiece();
    void setPlayerPiece(Image playerPiece);
    int getPlayerID();
    void setPlayerID(int playerID);
    Position getPlayerPosition();
    void setPlayerPosition(Position playerPosition);

}
