package Controllers;
/**
 * Created by zalmangagerman on 10/8/17.
 */

import java.util.ArrayList;
import java.util.List;

public class Board implements BoardI {

    private final List<PlayerI> players_;
    private final List<TileI> tiles_;
    private final int rowSize_;
    private final int colSize_;


    public Board(int rowSize, int colSize, List<PlayerI> teams) {
        rowSize_ = rowSize;
        colSize_ = colSize;
        tiles_ = new ArrayList<>();
        players_ = teams;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < rowSize; j++) {
                if (i == 0 & j == 0) {
                    tiles_.add(new Tile(i, j, players_));
                }
                tiles_.add(new Tile(i, j));
            }
        }
    }

    @Override
    public void movePlayerToTile(PlayerI player, int spaces) throws MoveException {

    }
}
