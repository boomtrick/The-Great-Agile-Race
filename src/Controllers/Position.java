package Controllers;
/**
 * 
 * created by Azamat Abdikadirov by Azamat Abdikadirov
 * 
 * The class creates a data structure that holds information about positions of Player and other game objects
 *
 */
public class Position {

	private int row;
	private int col;
	
	
	public Position() {

		row=0;
		col=0;
		
	}
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public void setPosition(int Row, int Col) {
		row = Row;
		col = Col;
	}
	
	
}
