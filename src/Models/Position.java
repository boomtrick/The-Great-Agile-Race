package Models;

import static Config.BoardConstants.*;

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
        if (row < INITIAL_ROW) {
            throw new IllegalArgumentException("Row too small");
        } if (row >= ROW_SIZE) {
            throw new IllegalArgumentException("Row too big");
        } if (col < INITIAL_COLUMN) {
            throw new IllegalArgumentException("Column too small");
        } if (col >= COL_SIZE) {
            throw new IllegalArgumentException("Column too big");
        }
		row_ = row;
        col_ = col;
    }

    @Override
	public int getRow() {
		return row_;
	}

    @Override
	public void setRow(int row) {
        if (row < INITIAL_ROW) {
            throw new IllegalArgumentException("Row too small");
        } if (row >= ROW_SIZE) {
            throw new IllegalArgumentException("Row too big");
        }
        this.row_ = row;
	}

    @Override
	public int getCol() {
		return col_;
	}

    @Override
	public void setCol(int col) {
        if (col < INITIAL_COLUMN) {
            throw new IllegalArgumentException("Column too small");
        } if (col >= COL_SIZE) {
            throw new IllegalArgumentException("Column too big");
        }
        this.col_ = col;
	}

    @Override
	public void setPosition(int row, int col) {
        if (row < INITIAL_ROW) {
            throw new IllegalArgumentException("Row too small");
        } if (row >= ROW_SIZE) {
            throw new IllegalArgumentException("Row too big");
        } if (col < INITIAL_COLUMN) {
            throw new IllegalArgumentException("Column too small");
        } if (col >= COL_SIZE) {
            throw new IllegalArgumentException("Column too big");
        }
        row_ = row;
		col_ = col;
	}

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Position)) { return false; }
        Position position = (Position) obj;
        if (row_ == position.getRow() && col_ == position.getCol()) { return true; }
        return false;
    }
	
}
