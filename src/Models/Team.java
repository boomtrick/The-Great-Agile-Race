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
    private int numOfPlayers;

    public Team (TeamColor color, int teamSize){
        color_=color;
        numOfPlayers=teamSize;
    }

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
    public List<PlayerI> getPlayers() throws NotImplementedException {
        return players_;
    }

    @Override
    public void setPlayers(List<PlayerI> players) throws NotImplementedException {

        this.players_ = players;
    }

    @Override
    public void addPlayer(PlayerI player) {
        for (int i=0; i<numOfPlayers; i++)
        {
            players_.add(player);
        }

    }
}
