package Models;

import Config.BoardConstants.TeamColor;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Config.BoardConstants.TeamColor.BLUE;
import static Config.BoardConstants.TeamColor.RED;

public class Team implements TeamI {

    /*
    Holds getters, setters and methods for accessing Fact data
 */
    private final TeamColor color_;
    private List<PlayerI> players_;


    public Team(TeamColor color) {
        this(color, new ArrayList<PlayerI>());
    }

    //Returns game piece based on team color
    public BufferedImage getGamePiece(){
        BufferedImage img = null;

        try
        {
            if (getColor() == RED){//return red image

                img = ImageIO.read(new File("src/Views/Images/red-piece.png"));

            } else if (getColor() == BLUE){

                img = ImageIO.read(new File("src/Views/Images/blue-piece.png"));
            }

            System.out.println("image found");
        }
        catch (IOException e) {
            System.out.println("No image found");
        }

        return img;
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
        List<PlayerI> ret = new ArrayList<>();
        for (PlayerI player : players_) {
            ret.add(player);
        }
        return players_;
    }

    @Override
    public void setPlayers(List<PlayerI> players) throws NotImplementedException {
        //don't test this
        this.players_ = players;
    }

    @Override
    public void addPlayer(PlayerI player) {
        players_.add(player);
    }

    @Override
    public int getTeamSize() {
        return players_.size();
    }

    @Override
    public BufferedImage addPlayerByName(String name, int teamMemberNum) {
        Random rand=new Random();
        int randomNum= rand.nextInt(1000000000)+1;
        PlayerI ret = new Player(name, randomNum, color_, teamMemberNum);
        players_.add(ret);
        return ret.getPlayerPiece();
    }

}
