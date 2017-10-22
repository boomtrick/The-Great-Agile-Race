package Controllers;

/**
 * Created by zalmangagerman on 10/15/17.
 */
import Models.Fact;
import Models.Quiz;

import java.util.ArrayList;
import java.util.List;

public class TileController implements TileI {
    private final int row_;
    private final int col_;
    private final List<PlayerI> players_;
    private final boolean event_;


    public TileController(int row, int col, boolean event) {
        this(row, col, new ArrayList<PlayerI>(), event);
    }

    public TileController(int row, int col, List<PlayerI> players, boolean event) {
        row_ = row;
        col_ = col;
        players_ = players;
        event_ = event;
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
//        if (newPlayer.getTeam() == RED) {
//            players_.add(newPlayer);
//        } //TOdo streamline
        System.out.println(newPlayer.getId() + " added to tile <" + row_ + ", " + col_ + ">");
    }

    @Override
    public void deletePlayer(PlayerI player) {
        int origSize = players_.size();
        int id = player.getId();
        for (PlayerI thisPlayer : players_) {
            if (id == thisPlayer.getId()) {
                players_.remove(player);
                System.out.println(id + " deleted from tile <" + row_ + ", " + col_ + ">");
            }
        }
        if (players_.size() == origSize) {
            throw new IllegalArgumentException(id + " wasn't on the tile");
        }
    }

    @Override
    public boolean has(PlayerI player) {
        for (PlayerI curPlayer : players_) {
            if (curPlayer.getId() == player.getId()) {
                return true;
            }
        }
        return false;
    }

    public int getNumberByTeam(Config.BoardConstants.Team team) {
        int ret = 0;
        for (PlayerI player : players_) {
            if (player.getTeam() == team) { ret++; }
        }
        return ret;
    }

    public boolean hasEvent() {
        return event_;
    }
}
