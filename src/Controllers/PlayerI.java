package src.Controllers;
/**
 * Created by zalmangagerman on 10/8/17.
 * 
 */
import java.awt.Image;

import src.Config.BoardConstants;
import src.Controllers.Position;
import src.Config.BoardConstants.Team;
public interface PlayerI {
    void move(int i, int j);
    int getId();
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
