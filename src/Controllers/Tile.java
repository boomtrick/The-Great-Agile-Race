package Controllers;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 * Tile can hold a drawable object. i.e piece and draws it on the board if it exists
 */
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
	
	
}
