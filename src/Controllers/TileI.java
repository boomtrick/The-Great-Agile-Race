package Controllers;

import Models.PlayerI;

/**
 * Created by zalmangagerman on 10/8/17.
 */

public interface TileI {
    int getRow();
    int getCol();
    void insertPlayer(PlayerI player);
    void deletePlayer(PlayerI player) throws PlayerNotFoundException;
    boolean has(PlayerI player);
    boolean hasEvent();
    int getSize();

}
