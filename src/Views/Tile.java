package Views;

import Controllers.IDrawable;

import javax.swing.*;
import java.awt.*;

/**
 * TileController can hold a drawable object. i.e piece and draws it on the board if it exists
 */
public class Tile extends JPanel {

	private IDrawable drawP1;
	private IDrawable drawP2;
	private IDrawable drawP3;
	private IDrawable drawP4;
	private IDrawable drawP5;
	//update to hold more than one drawable
	//update to be a border layout

	public Tile()
	{
		this.setLayout(new BorderLayout());
		this.setOpaque(false);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK) );
		this.setPreferredSize(new Dimension(50,50) );

	}
	
	public Tile(IDrawable drawable) {
		this();
		this.drawP2 = drawable;
    }

    public void setDrawable(IDrawable drawable) {
		this.drawP1 = drawable;
        repaint();
    }

    @Override
	public void paintComponent(Graphics g) {
		if(drawP1 != null){
			drawP1.draw(g);
		}
	}
}
