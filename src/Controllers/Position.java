package Controllers;

import static Config.BoardConstants.INITIAL_COLUMN;
import static Config.BoardConstants.INITIAL_ROW;

/**
 * 
 * created by Azamat Abdikadirov by Azamat Abdikadirov
 * 
 * The class creates a data structure that holds information about positions of Player and other game objects
 *
 */
public class Position implements PositionI {


	private int row_;
	private int col_;
	
	
	public Position() {
		/**
		 * When object is created, its position is set to 0,0 before rolling dice. Therefore, it can not be seen before rolling dice
		 */
        row_ = INITIAL_ROW;
		col_ = INITIAL_COLUMN;
		
	}

    public Position(int row, int col) {
        row_ = row;
        col_ = col;
    }

    @Override
	public int getRow() {
		return row_;
	}

    @Override
	public void setRow(int row) {
		this.row_ = row;
	}

    @Override
	public int getCol() {
		return col_;
	}

    @Override
	public void setCol(int col) {
		this.col_ = col;
	}

    @Override
	public void setPosition(int row, int col) {
		row_ = row;
		col_ = col;
	}
	
}
