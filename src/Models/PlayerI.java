package Models;

/**
 * Created by zalmangagerman on 10/8/17.
 * 
 */
import Config.BoardConstants.TeamColor;

import java.awt.*;
import java.awt.image.BufferedImage;

public interface PlayerI {
    void move(int i, int j);
    int getId();
    TeamColor getTeam();
    String getPlayerName();
    BufferedImage getPlayerPiece();

    void rememberFact(FactI factIn);
    boolean checkIfKnowsFact(FactI factIn);

    PositionI getPlayerPosition();
    void setPlayerPosition(PositionI playerPosition);
}
