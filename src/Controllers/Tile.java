package Controllers;
/**
 * Created by zalmangagerman on 10/8/17.
 */
import static Config.BoardConstants.Team.*;

import java.util.ArrayList;
import java.util.List;
public class Tile implements TileI {
    private final int row_;
    private final int col_;
    private List<PlayerI> players_;

    public Tile(int row, int col) {
        players_ = new ArrayList<>();
        row_ = row;
        col_ = col;
    }


    public Tile(int row, int col, List<PlayerI> players) {
        row_ = row;
        col_ = col;
        players_ = players;
    }

    @Override
    public int getRow() {
        return row_;
    }

    @Override
    public int getCol()
    {
        return col_;
    }

    @Override
    public void insertPlayer(PlayerI newPlayer) {
        if (newPlayer.getTeam() == red) {
            players_.add(newPlayer);
        } //TOdo streamline
        System.out.println(newPlayer.getId() + " added to tile <" + row_ + ", " + col_ + ">");
    }

    @Override
    public void deletePlayerById(String id) {
        int origSize = players_.size();
        for (PlayerI player : players_) {
            if (player.getId().equals(id)) {
                players_.remove(player);
                System.out.println(id + " deleted from tile <" + row_ + ", " + col_ + ">");
            }
        }
        if (players_.size() == origSize) {
            throw new IllegalArgumentException(id + " wasn't on the tile");
        }
    }
}
