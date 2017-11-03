package Controllers;
/**
 * Created by zalmangagerman on 10/15/17.
 */

import Config.BoardConstants;
import Models.PlayerI;

import java.util.ArrayList;
import java.util.List;
public class BoardController implements BoardI {

    private final List<PlayerI> players_;
    private final List<TileI> tiles_;
    private final int rowSize_;
    private final int colSize_;

    public BoardController(int rowSize, int colSize, List<PlayerI> players) {
        assert rowSize > 0;
        assert colSize > 0;
        assert players != null;

        rowSize_ = rowSize;
        colSize_ = colSize;
        tiles_ = new ArrayList<>();
        players_ = players;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < rowSize; j++) {
                if (i == 0 & j == 0) {
                    tiles_.add(new TileController(i, j, players_, BoardConstants.spEvSpaces[i][j]));
                }
                tiles_.add(new TileController(i, j, BoardConstants.spEvSpaces[i][j]));
            }
        }
    }

    @Override
    public boolean movePlayerToTile(PlayerI player, int row, int column) throws MoveException {

            for (TileI tile : tiles_) {
                if (tile.has(player) && tile.getCol() != column && tile.getRow() != row) {
                    try { tile.deletePlayer(player); }
                    catch (PlayerNotFoundException pnfe) { // todo do something
                    }
                    for (TileI tile2 : tiles_) {
                        if (tile2.getCol() == column && tile2.getRow() == row) {
                            tile2.insertPlayer(player);
                            return tile2.hasEvent();
                        }
                    }
                }
            }
        return false;
    }

    @Override
    public int getRowSize() {
        return rowSize_;
    }

    @Override
    public int getColSize() {
        return colSize_;
    }
}
