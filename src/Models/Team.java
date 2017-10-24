package Models;

import Config.BoardConstants.TeamColor;
import Controllers.PlayerI;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class Team implements TeamI {

    /*
    Holds getters, setters and methods for accessing Fact data
 */
    private final TeamColor color_;
    private List<PlayerI> players_;

    public Team(TeamColor color) {
        this(color, new ArrayList<PlayerI>());
    }

    public Team(TeamColor color, List<PlayerI> players) {
        color_ = color;
        players_ = players;
    }

    @Override
    public TeamColor getColor() {
        return color_;
    }

    @Override
    public List<PlayerI> getPlayers() {
        throw new NotImplementedException();
    }

    @Override
    public void setPlayers(List<PlayerI> players) {
        throw new NotImplementedException();
        //this.players_ = players;
    }

    @Override
    public void addPlayer(PlayerI player) {
        players_.add(player);
    }
}
