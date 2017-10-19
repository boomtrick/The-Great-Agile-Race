package Controllers;
/**
 * Created by zalmangagerman on 10/8/17.
 * 
 */
import java.awt.Image;

import Config.BoardConstants;
import Controllers.Position;
import Config.BoardConstants.Team;
public interface PlayerI {
    void move(int i, int j);
    String getId();
    Team getTeam();
    String getPlayerName();
    void setPlayerName(String playerName);
    Image getPlayerPiece();
    void setPlayerPiece(Image playerPiece);
    int getPlayerID();
    void setPlayerID(int playerID);
    Position getPlayerPosition();
    void setPlayerPosition(Position playerPosition);

}
