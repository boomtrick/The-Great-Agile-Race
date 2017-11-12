package Views;

import Controllers.IDrawable;
import Models.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * TileController can hold a drawable object. i.e piece and draws it on the board if it exists
 */
public class Tile extends JPanel {

	private ArrayList<IDrawable> drawables = new ArrayList<IDrawable>();
	private ArrayList<Player> players = new ArrayList<Player>();
	public Tile()
	{
		this.setLayout(new GridLayout());
		this.setOpaque(false);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK) );
		this.setPreferredSize(new Dimension(50,50) );

	}
	
	public Tile(IDrawable drawable) {
		this();
		drawables.add(drawable);
    }
	

    public void setDrawable(Player p) {
		players.add(p);
        repaint();
    }

    @Override
	public void paintComponent(Graphics g) {
    	
    	for(Player playa : players)
    	{
    		playa.draw(g);
    	}
	}
}
