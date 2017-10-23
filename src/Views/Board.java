package Views;
/**
 * Created by zalmangagerman on 10/8/17.
 */

import java.awt.*;
import javax.swing.JPanel;
import Views.Tile;

public class Board extends JPanel {
	private Tile[][] tiles;
	private int rows;
	private int cols;

	public Board(int rows, int cols)
	{
		setLayout(new GridLayout(rows,cols));

		this.rows = rows;
		this.cols = cols;
		tiles = new Tile[rows][cols];
		this.setOpaque(false);
		populateBoard();
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
}
