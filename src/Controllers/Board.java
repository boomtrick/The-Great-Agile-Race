package Controllers;
/**
 * Created by zalmangagerman on 10/8/17.
 */
import java.util.List;

public class Board implements BoardI {

    private final List<List<PlayerI>> teams_;
    //private final List<TileI> tiles_;
    private final int rowSize_;


    public Board(int rowSize, List<List<PlayerI>> teams) {
        rowSize_ = rowSize;
        teams_ = teams;
    }

    @Override
    public void movePlayerToTile(PlayerI player, int spaces) throws MoveException {

    }
}
