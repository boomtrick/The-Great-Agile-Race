package Controllers;

/**
 * Created by zalmangagerman on 10/8/17.
 */
public interface BoardI {
    void movePlayerToTile(PlayerI player, int spaces) throws MoveException;
}
