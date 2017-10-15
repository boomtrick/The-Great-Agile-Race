package Controllers;
/**
 * Created by zalmangagerman on 10/8/17.
 */

public interface TileI {
    int getRow();
    int getCol();
    void insertPlayer(PlayerI player);
    void deletePlayerById(String id) throws PlayerNotFoundException;
    boolean has(PlayerI player);

}
