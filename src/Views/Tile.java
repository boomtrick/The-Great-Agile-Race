package Views;

import Controllers.IDrawable;

import javax.swing.*;
import java.awt.*;

/**
 * TileController can hold a drawable object. i.e piece and draws it on the board if it exists
 */
public class Tile extends JPanel {

	private IDrawable drawable;

	public Tile()
	{
		this.setOpaque(false);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK) );
		this.setPreferredSize(new Dimension(50,50) );
	}
	
	public Tile(IDrawable drawable) {
		this();
        this.drawable = drawable;
    }

    public void setDrawable(IDrawable drawable) {
        this.drawable = drawable;
        repaint();
    }

    @Override
	public void paintComponent(Graphics g) {
		if(drawable != null){
			drawable.draw(g);
		}
	}
}
