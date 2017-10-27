package Controllers;

/**
 * Created by zalmangagerman on 10/8/17.
 */
public interface BoardI {
    boolean movePlayerToTile(PlayerI player, int row, int col) throws MoveException;
    int getRowSize();
    int getColSize();
}
