package Controllers;
<<<<<<< HEAD

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

=======
>>>>>>> feature/Enabling_GUI_Interface
/**
 * Tile can hold a drawable object. i.e piece and draws it on the board if it exists
 */
<<<<<<< HEAD
public class Tile extends JPanel{

	private IDrawable drawable;
	
	
	public Tile()
	{
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK) );
		this.setPreferredSize(new Dimension(100,100) );
	}
	
	public Tile(IDrawable drawable) {
		this();
        this.drawable = drawable;
    }

    public void setDrawable(IDrawable drawable) {
        this.drawable = drawable;
        repaint();
    }

	public void paintComponent(Graphics g) {
		if(drawable != null){
			drawable.draw(g);
		}
		
	}
	
	
=======
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
>>>>>>> feature/Enabling_GUI_Interface
}
