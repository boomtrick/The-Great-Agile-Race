package Controllers;
/**
 * Created by zalmangagerman on 10/15/17.
 */

import java.util.ArrayList;
import java.util.List;
public class BoardController implements BoardI {


    private final List<PlayerI> players_;
    private final List<TileI> tiles_;
    private final int rowSize_;
    private final int colSize_;


    public BoardController(int rowSize, int colSize, List<PlayerI> players) {
        rowSize_ = rowSize;
        colSize_ = colSize;
        tiles_ = new ArrayList<>();
        players_ = players;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < rowSize; j++) {
                if (i == 0 & j == 0) {
                    tiles_.add(new TileController(i, j, players_));
                }
                tiles_.add(new TileController(i, j));
            }
        }
    }

    @Override
    public void movePlayerToTile(PlayerI player, int row, int column) throws MoveException {
        for (TileI tile : tiles_) {
            try {
                if (tile.has(player) && tile.getCol() != column && tile.getRow() != row) {
                    tile.deletePlayerById(player.getId());
                    for (TileI tile2 : tiles_) {
                        if (tile2.getCol() == column && tile2.getRow() == row) {
                            tile2.insertPlayer(player);
                        }
                    }
                }
            } catch (PlayerNotFoundException pnfe) {
                // todo do something
            }
        }
    }
}