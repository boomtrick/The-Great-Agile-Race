package Views;
/**
 * Created by zalmangagerman on 10/8/17.
 */

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import Controllers.IDrawable;
import Models.Player;
import Views.Tile;

public class Board extends JPanel {
	private Tile[][] tiles;
	private int rows;
	private int cols;
	private Image img;


	public Board(int rows, int cols,Image img)
	{
		this.img = img;
		this.rows = rows;
		this.cols = cols;
		tiles = new Tile[rows][cols];
		
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    
	    setLayout(new GridLayout(rows,cols));
		
	    populateBoard();
	}

	public void initPieces(BufferedImage playerPiece){
		IDrawable d = new IDrawable() {
			@Override
			public void draw(Graphics g) {
				g.drawImage(playerPiece, 0, 0, null);
			}
		};
		tiles[9][0].setDrawable(d);

	}
	
	public void drawTiles()
	{
		for(int i = 0 ; i < rows; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				
				
			}
		}
	}
	private void populateBoard() {
		for(int i = 0 ; i < rows; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				Tile t = new Tile();
				tiles [i][j] = t;
				this.add(t);
			}
		}
	}
	
	@Override
	public void paintComponent(Graphics page)
	{

		page.drawImage(img, 0, 0, null);
	}
}
