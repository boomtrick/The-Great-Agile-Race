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
    private final Fact fact_;
    private final Quiz quiz_;
    private final List<PlayerI> players_;


    public TileController(int row, int col) {
        this(row, col, new Fact(), new Quiz());
    }

    public TileController(int row, int col, List<PlayerI> players) {
        this(row, col, new Fact(), new Quiz(), players);
    }

    public TileController(int row, int col, Fact fact) {
        this(row, col, fact, new Quiz());
    }

    public TileController(int row, int col, Fact fact, List<PlayerI> players) {
        this(row, col, fact, new Quiz(), players);
    }

    public TileController(int row, int col, Quiz quiz) {
        this(row, col, new Fact(), quiz);
    }

    public TileController(int row, int col, Quiz quiz, List<PlayerI> players) {
        this(row, col, new Fact(), quiz, players);
    }

    private TileController(int row, int col, Fact fact, Quiz quiz) {
        this(row, col, fact, quiz, new ArrayList<>());
    }


    private TileController(int row, int col, Fact fact, Quiz quiz, List<PlayerI> players) {
        row_ = row;
        col_ = col;
        fact_ = fact;
        quiz_ = quiz;
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
//        if (newPlayer.getTeam() == RED) {
//            players_.add(newPlayer);
//        } //TOdo streamline
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

    @Override
    public boolean has(PlayerI player) {
        for (PlayerI curPlayer : players_) {
            if (curPlayer.getId().equals(player.getId())) {
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
}
