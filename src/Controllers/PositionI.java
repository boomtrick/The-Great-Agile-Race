package Controllers;

/**
 * Created by zalmangagerman on 10/24/17.
 */
public interface PositionI {
    int getRow();
    void setRow(int row);
    int getCol();
    void setCol(int col);
    void setPosition(int row, int col);
}
